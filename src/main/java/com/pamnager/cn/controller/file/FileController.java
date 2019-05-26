package com.pamnager.cn.controller.file;

import com.pamnager.cn.common.EasyuiRespData;
import com.pamnager.cn.common.RespData;
import com.pamnager.cn.entity.File;
import com.pamnager.cn.service.FileOperateService;
import com.pamnager.cn.service.FileService;
import com.pamnager.cn.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileController {



    private static final String TIEAM = "tieam";

    @Autowired
    private FileOperateService operateService;

    @Resource
    private FileService fileService;


    @RequestMapping("fileadd")
    @ResponseBody
    public RespData fileadd(@RequestParam("file") MultipartFile file){
        
        try {
            if (!operateService.isLegalFileSize(file)){
                return RespData.fail("文件过大，请重选择文件上传新上传");
            }
            if (!operateService.isLegalFileFormat(file)){
                return RespData.fail("请选择合法的文件格式上传");
            }

            String filePrefix = operateService.getFilePrefix(file);
            String extenson = operateService.getFileExtension(file);


            String fileNewName = TIEAM + UUIDUtil.getRandomBeginTimePk();

            //组装参数， 数据入库
            File entityFile = new File();
            entityFile.setFileName(filePrefix);
            entityFile.setFileExtension(extenson);
            entityFile.setFileSize(file.getSize());
            entityFile.setFileUniqueName(fileNewName);
            fileService.saveFile(entityFile);
        } catch (Exception e) {
            // TODO: 2019/5/26 0026 异常处理,log
        }
        // tika解析文件
        //  落盘
        // /25 0025 落盘之后异步开始存入ElasticSearch数据库
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



}
