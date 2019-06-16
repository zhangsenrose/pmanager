package com.pamnager.cn.common;

import com.pamnager.cn.helper.ConfigUtil;
import io.minio.MinioClient;
import io.minio.errors.*;

/**
 * @Author: zhangsw
 * @Date: 2019/6/11
 * @Version 1.0
 * MiniooUtil工具类，单例类
 */
public class MinioClientUtil {



    private static String minioEndPoint = ConfigUtil.getAttribute("minioEndpoint");

    private static String minioAccessKey = ConfigUtil.getAttribute("minioAccessKey");

    private static String minioSerectKey = ConfigUtil.getAttribute("minioSerectKey");


    private static MinioClientUtil minioClientUtil;

    private static MinioClient minioClient;

    public static MinioClientUtil getInstance(){
        if (null != minioClientUtil){
            return minioClientUtil;
        }

        synchronized (MinioClientUtil.class){
            if (null == minioClientUtil){
                minioClientUtil = new MinioClientUtil();
            }
        }

        return minioClientUtil;
    }


    public MinioClient getMinioClient(){
        return minioClient;
    }

    private MinioClientUtil(){
        init();
    }

    private void init(){
        try {
            //System.out.println(minioEndPoint + minioAccessKey + minioSerectKey);
            minioClient =  new MinioClient(minioEndPoint, minioAccessKey, minioSerectKey);
        } catch (InvalidEndpointException e) {
            e.printStackTrace();
        } catch (InvalidPortException e) {
            e.printStackTrace();
        }
    }


    public boolean bucketExists(String bucketName){
        try {
            if (minioClient.bucketExists(bucketName)){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }



    public boolean createBucket(String bucketName){
        boolean isCreate = false;
        try {
            if (!minioClient.bucketExists(bucketName)){
                minioClient.makeBucket(bucketName);
                isCreate = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isCreate;
    }





}
