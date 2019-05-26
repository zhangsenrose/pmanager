package com.pamnager.cn.service;

import com.drew.imaging.FileType;
import org.springframework.web.multipart.MultipartFile;

public interface FileOperateService {

    /**
     * 是否超过最大的上传文件大小
     * @param file
     * @return
     */
    boolean isLegalFileSize(MultipartFile file);


    FileType getFileType(MultipartFile file);


    /**
     * 获取文件的后缀名
     * @param file
     * @return
     */
    String getFileExtension(MultipartFile file);


    /**
     * 判断是否为合法的文件格式
     * @param file
     * @return
     */
    boolean isLegalFileFormat(MultipartFile file);

    /**
     * 获取文件的前缀
     * @param file
     * @return
     */
    String getFilePrefix(MultipartFile file);

}
