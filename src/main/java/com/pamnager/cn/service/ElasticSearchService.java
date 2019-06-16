package com.pamnager.cn.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: zhangsw
 * @Date: 2019/6/14
 * @Version 1.0
 */
public interface ElasticSearchService {

    void saveDocs(MultipartFile file, String fileUniqueName);


}
