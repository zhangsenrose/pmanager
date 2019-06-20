package com.pamnager.cn.service.impl;

import org.apache.ibatis.jdbc.SQL;

/**
 * @Author: zhangsw
 * @Date: 2019/6/17
 * @Version 1.0
 */
public class TestSqlImpl {


    public static void main(String[] args) {
        System.out.println(new SQL().SELECT("name").toString());
    }

}
