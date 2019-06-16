package com.pamnager.cn.service.impl;

import com.pamnager.cn.common.RespData;
import com.pamnager.cn.service.MinioService;
import io.minio.MinioClient;
import io.minio.Result;
import io.minio.errors.*;
import io.minio.messages.Item;
import org.apache.http.HttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xmlpull.v1.XmlPullParserException;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: zhangsw
 * @Date: 2019/6/14
 * @Version 1.0
 */
@Service
public class MinioServiceImpl implements MinioService {


    private static final String bucketName = "tieam";


    @Override
    public void saveFileToMinio(MultipartFile file, String fileNewName, String extensionm, MinioClient minioClient) {
        InputStream inputStream = null;
        try {
            String fileName = fileNewName + "." + extensionm;
            inputStream = file.getInputStream();
            minioClient.putObject("tieam", fileName, inputStream, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void downloadMinioFile(String fileName, MinioClient minioClient,  HttpServletResponse response) {
        InputStream inputStream = null;
        OutputStream out = null;
        try {
            inputStream = minioClient.getObject(bucketName, fileName);
            out = response.getOutputStream();
            int len = 0;
            byte[] buffer = new byte[1024];
            response.reset();
            response.addHeader("Content-Disposition",
                    " attachment;filename=" + fileName);
            response.setContentType("application/octet-stream");
            while ((len = inputStream.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean isDocExists(String fileName, MinioClient minioClient) {
        try {
            if (minioClient.bucketExists(bucketName)){
                Iterable<Result<Item>> resultObjects = minioClient.listObjects(bucketName);
                for (Result<Item> result : resultObjects){
                    Item item = result.get();
                    if (item.objectName().equals(fileName)){
                        return true;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }





}
