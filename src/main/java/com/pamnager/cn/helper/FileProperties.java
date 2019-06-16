package com.pamnager.cn.helper;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.util.Properties;

/**
 * @Author: zhangsw
 * @Date: 2019/6/12
 * @Version 1.0
 */
public class FileProperties extends Properties {


    public FileProperties(String path){
        try{
            Resource resource = new DefaultResourceLoader().getResource(path);
            load(resource.getInputStream());
        }catch (Exception e){
            System.err.println("Exception in FileProperties(String): " + e.toString() + " for filename=" + path);
        }
    }

    public FileProperties(Properties properties){
        super(properties);
    }


    public static void main(String[] args) {
        FileProperties fp = new FileProperties("/config.properties");
        System.out.println(fp.getProperty("minioEndpoint"));
    }
}
