package com.pamnager.cn.dao;

import com.pamnager.cn.entity.File;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FileMapper {
    int deleteByPrimaryKey(Long id);

    int insert(File record);

    int insertSelective(File record);

    File selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKey(File record);

    /**
     * 获取分页的文件
     * @param current
     * @param pageSize
     * @return
     */
    List<File> getFilesByPage(@Param("current") Integer current, @Param("pageSize") Integer pageSize);

}