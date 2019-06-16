package com.pamnager.cn.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.pamnager.cn.common.ESTransportClient;
import com.pamnager.cn.common.TikaUtil;
import com.pamnager.cn.service.ElasticSearchService;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: zhangsw
 * @Date: 2019/6/14
 * @Version 1.0
 */
@Service
public class ElasticSearchServiceImpl implements ElasticSearchService {


    private TransportClient client = ESTransportClient.getInstance();


    @Override
    public void saveDocs(MultipartFile file, String fileUniqueName) {
        String originalFilename = file.getOriginalFilename();
        String fileContent = TikaUtil.getDocContent(file);
        IndexRequestBuilder requestBuilder = client.prepareIndex();
        requestBuilder.setIndex("documentindex");
        requestBuilder.setType("documentType");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("fileName", originalFilename.substring(0, originalFilename.lastIndexOf('.')));
        jsonObject.put("fineUniqueName", fileUniqueName);
        jsonObject.put("fileSize", file.getSize());
        jsonObject.put("fileContent", fileContent);
        requestBuilder.setSource(jsonObject, XContentType.JSON);
        IndexResponse response = requestBuilder.get();
    }




}
