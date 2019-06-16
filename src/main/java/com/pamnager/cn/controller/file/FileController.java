package com.pamnager.cn.controller.file;

import com.pamnager.cn.common.EasyuiRespData;
import com.pamnager.cn.common.MinioClientUtil;
import com.pamnager.cn.common.RespData;
import com.pamnager.cn.entity.File;
import com.pamnager.cn.service.ElasticSearchService;
import com.pamnager.cn.service.FileOperateService;
import com.pamnager.cn.service.FileService;
import com.pamnager.cn.service.MinioService;
import com.pamnager.cn.util.UUIDUtil;
import io.minio.MinioClient;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileController {


    @Autowired
    private FileOperateService operateService;

    @Resource
    private FileService fileService;

    @Resource
    private MinioService minioService;

    @Resource
    private ElasticSearchService elasticSearchService;

    private MinioClientUtil minioClientUtil = MinioClientUtil.getInstance();


    @RequestMapping("fileadd")
    @ResponseBody
    public RespData fileadd(@RequestParam("file") MultipartFile file){
        try {
            if (!operateService.isLegalFileSize(file)){
                return RespData.fail("文件过大，请重选择文件上传新上传");
            }
            if (!operateService.isLegalFileFormat(file)){
                return RespData.fail("文件格式不合法，请重新上传！");
            }
            String filePrefix = operateService.getFilePrefix(file);
            String extenson = operateService.getFileExtension(file);
            String fileNewName = UUIDUtil.getRandomBeginTimePk();
            //数据入库
            File entityFile = new File();
            entityFile.setFileName(filePrefix);
            entityFile.setFileExtension(extenson);
            entityFile.setFileSize(file.getSize());
            entityFile.setFileUniqueName(fileNewName);
            fileService.saveFile(entityFile);
            if (!minioClientUtil.bucketExists("tieam")){
                minioClientUtil.createBucket("tieam");
            }
            minioService.saveFileToMinio(file, fileNewName, extenson,  minioClientUtil.getMinioClient());
            elasticSearchService.saveDocs(file, fileNewName + "." + extenson);
        } catch (Exception e) { }
        return RespData.success("上传成功");
    }


    /**
     * easyui数据网格请求数据
     * @return
     */
    @RequestMapping("filelist")
    @ResponseBody
    public EasyuiRespData fileadd(Integer page, Integer rows){
        EasyuiRespData easyuiRespData = new EasyuiRespData();

        List<File> files = fileService.getFilesByPage(page, rows);

        easyuiRespData.setRows(files);

        return easyuiRespData;
    }



    @RequestMapping("downloadFile")
    @ResponseBody
    public RespData downloadFile(String fileName, HttpServletResponse response){
        if (StringUtils.isBlank(fileName)){
            return RespData.fail("文件名称不能为空");
        }

        if (!minioService.isDocExists(fileName, minioClientUtil.getMinioClient())){
            return RespData.fail("文件不存在");
        }
        minioService.downloadMinioFile(fileName, minioClientUtil.getMinioClient(), response);
        return RespData.success("下载成功");
    }





}
