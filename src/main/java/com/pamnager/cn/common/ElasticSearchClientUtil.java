package com.pamnager.cn.common;

import org.apache.poi.ss.formula.functions.T;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.client.transport.TransportClient;

/**
 * @Author: zhangsw
 * @Date: 2019/6/21
 * @Version 1.0
 */
public class ElasticSearchClientUtil {


    private TransportClient client = ESTransportClient.getInstance();



    /**
     * 判断索引是否存在
     * @param indexName
     * @return
     */
    public boolean isIndexExist(String indexName){
        IndicesExistsRequest ieq = new IndicesExistsRequest();
        ieq.indices(indexName);
        boolean exists = client.admin().indices().exists(ieq).actionGet().isExists();
        return exists;
    }
    public boolean isIndexExists(String indexName){
        return  client.admin().indices().prepareExists(indexName).execute().actionGet().isExists();
    }

    /**
     * 删除索引
     * @param indexName
     * @return
     */
    public boolean deleteIndex(String indexName){
        return isIndexExists(indexName) ? client.admin().indices().prepareDelete(indexName).execute().actionGet().isAcknowledged()
                : false;
    }

    /**
     * 新增索引
     * @param indexName
     * @return
     */
    public  boolean addIndex(String indexName){
        if (isIndexExists(indexName)){
            //索引已经存在
            return false;
        }
        return client.admin().indices().prepareCreate(indexName).execute().actionGet().isShardsAcked();
    }


    /**
     * 判断指定index下的type是否存在
     * @param indexName
     * @param typeName
     * @return
     */
    public boolean isTypeExist(String indexName, String typeName){
        if (!isIndexExists(indexName)){
            //索引不存在
            return false;
        }

        return client.admin().indices().prepareTypesExists(indexName).setTypes(typeName).execute().actionGet().isExists();
    }

    /**
     * @param indexName
     * @param typeName
     * @return
     */
    public boolean addType(String indexName, String typeName){
       return false;
    }


    public boolean addIndexAndType(String index, String type, String mapping){
        CreateIndexRequestBuilder cirb = client.admin().indices().prepareCreate(index);
        return true;
    }

    public boolean addDocument(String indexName, String typeName){
        return true;
    }













}
