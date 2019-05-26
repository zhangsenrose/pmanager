package com.pamnager.cn.common;

/**
 * 统一web返回格式
 */
public class RespData {

    private Integer code;
    private String message;
    private Object data;

    private static final Integer SUCCESS_CODE = 200;
    private static final Integer FAIL_CODE = 400;

    public RespData(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public RespData(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    //GETTER  AND SETTER
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    //extra method
    public static RespData success(String message){
        return new RespData(SUCCESS_CODE,message,null);
    }

    public static  RespData success(Integer code, String message,Object data){
        return new RespData(code,message,data);
    }

    public static RespData returnObject(Object object){
        return new RespData(SUCCESS_CODE,"success",object);
    }

    public static RespData fail(String message){
        return new RespData(FAIL_CODE,message);
    }

    public static RespData fail(Integer code,String message){
        return new RespData(code,message);
    }

    public static RespData fail(Integer code, String message, Object object){
        return new RespData(code, message, object);
    }







}
