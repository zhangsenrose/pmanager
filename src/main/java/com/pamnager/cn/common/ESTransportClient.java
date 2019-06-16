package com.pamnager.cn.common;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;

/**
 * @Author: zhangsw
 * @Date: 2019/6/14
 * @Version 1.0
 * ESClient连接类
 */
public class ESTransportClient {

    private static TransportClient client;



    public static TransportClient getInstance(){
        return client;
    }

    private ESTransportClient(){

    }

    static {
        Settings settings = Settings.builder().put("cluster.name", "elasticsearch")
                .put("client.transport.sniff", true).build();

        client = new PreBuiltTransportClient(settings);
        try {
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






}
