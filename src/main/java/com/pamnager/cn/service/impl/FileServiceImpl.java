package com.pamnager.cn.service.impl;

import com.pamnager.cn.dao.FileMapper;
import com.pamnager.cn.entity.File;
import com.pamnager.cn.service.FileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Resource
    private FileMapper fileMapper;







    @Override
    public File saveFile(File file) throws Exception {
        fileMapper.insertSelective(file);
        return file;
    }

    @Override
    public List<File> getAllFile() {
        return null;
    }

    @Override
    public List<File> getFilesByPage(int current, int pageSize) {
        System.out.println(current + "=========" + pageSize);
        return fileMapper.getFilesByPage(current, pageSize);
    }
}
