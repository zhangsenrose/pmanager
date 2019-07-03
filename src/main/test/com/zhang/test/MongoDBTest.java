package com.zhang.test;

import com.alibaba.fastjson.JSON;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author: zhangsw
 * @Date: 2019/6/26
 * @Version 1.0
 */
public class MongoDBTest {


    private  MongoClient mongoClient = null;


    @Before
    public void  beforeDo(){
        //实例化Mongo对象，连接27017端口
        mongoClient = new MongoClient("127.0.0.1", 27017);
    }


    @Test
    public void testMongodb01(){
        MongoDatabase database = mongoClient.getDatabase("db01");
        MongoCollection<Document> documents = database.getCollection("collection1");
        Document document = new Document();
        document.put("id", 10001);
        document.put("msg", "测试一下第一次测试第一次一次次");
        documents.insertOne(document);
    }


    @Test
    public void testMongodb02(){
        MongoDatabase db01 = mongoClient.getDatabase("db01");
        System.out.println("数据库连接成功");
        MongoCollection<Document> collection1 = db01.getCollection("collection1");
        System.out.println("集合 collection1 选取成功");
        /**
         * 检索所有文档
         * 1.获取迭代器
         * 2.获取游标
         * 3.通过游标遍历检索出的文档集合
         */
        FindIterable<Document> findIterable = collection1.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()){
            System.out.println(JSON.toJSONString(mongoCursor.next()));
        }
    }

}
