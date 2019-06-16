package com.pamnager.cn.common;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: zhangsw
 * @Date: 2019/6/14
 * @Version 1.0
 * TiKa解析工具类
 */
public class TikaUtil {


    public static String getDocContent(MultipartFile file){
        InputStream in = null;
        BodyContentHandler handler = null;
        try {
             handler = new BodyContentHandler();
            Parser parser = new  AutoDetectParser();
            Metadata metadata = new Metadata();
            ParseContext context = new ParseContext();
            in = file.getInputStream();
            parser.parse(in, handler, metadata, context);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return handler.toString();
    }






}
