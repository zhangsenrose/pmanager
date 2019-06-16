package com.pamnager.cn.helper;

/**
 * @Author: zhangsw
 * @Date: 2019/6/12
 * @Version 1.0
 */
public class ConfigUtil {

    private ConfigUtil(){
    }

    private static FileProperties SystemAttributes = new FileProperties("/config.properties");



    public static String getAttribute(String key) {
        if (SystemAttributes != null) {
            return SystemAttributes.getProperty(key);
        } else {
            return null;
        }
    }


    public static String getAttribute(String key, String defaultValue) {
        if (SystemAttributes != null) {
            return SystemAttributes.getProperty(key, defaultValue);
        } else {
            return null;
        }
    }

}
