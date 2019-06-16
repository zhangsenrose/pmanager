package com.pamnager.cn.service;

import com.pamnager.cn.common.RespData;
import io.minio.MinioClient;
import org.apache.http.HttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author: zhangsw
 * @Date: 2019/6/11
 * @Version 1.0
 */
public interface MinioService {


    /**
     * 保存文件到minio中
     * @param file
     * @param fileNewName
     * @return
     */
    public void saveFileToMinio(MultipartFile file, String fileNewName, String extensionm, MinioClient minioClient);


    public void downloadMinioFile(String fileName, MinioClient minioClient,  HttpServletResponse response);

    public boolean isDocExists(String fileName, MinioClient minioClient);


}
