package com.pamnager.cn.service;

import com.drew.imaging.FileType;
import com.pamnager.cn.entity.File;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {


    File saveFile(File file)throws Exception;

    List<File> getAllFile();



    List<File> getFilesByPage(int current, int pageSize);

}
