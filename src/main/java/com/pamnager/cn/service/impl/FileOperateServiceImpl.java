package com.pamnager.cn.service.impl;

import com.drew.imaging.FileType;
import com.pamnager.cn.service.FileOperateService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileOperateServiceImpl implements FileOperateService {


    private static final Long MAX_FILE_SIZE = 102400000L;



    private static final String[] legalExtensions = {
            "xml", "xls","xlsx", "doc", "docx", "txt"
    };


    @Override
    public boolean isLegalFileSize(MultipartFile file) {
        if (file.isEmpty()){
            return false;
        }
        if (file.getSize() > MAX_FILE_SIZE){
            return false;
        }

        return true;
    }

    @Override
    public FileType getFileType(MultipartFile file) {
        return null;
    }

    @Override
    public String getFileExtension(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (fileName.substring(0 ,fileName.lastIndexOf(".")) == ""){
            return "empty";
        }
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    @Override
    public boolean isLegalFileFormat(MultipartFile file) {
        String fileExtension = getFileExtension(file);
        for (String extension : legalExtensions){
            if (fileExtension.equals(extension)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String getFilePrefix(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        return fileName.substring(0 ,fileName.lastIndexOf("."));
    }
}
