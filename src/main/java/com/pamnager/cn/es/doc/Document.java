package com.pamnager.cn.es.doc;


import javax.xml.crypto.Data;

public class Document {
    private String documentId;
    //文件id， 方便下载
    private String fileId;
    //文档标题
    private String title;
    //文档描述
    private String description;
    //文档主体内容
    private String contentbody;
    //文档标签
    private String tags;
    //文档类型id
    private String typeId;
    private String typeName;
    //大的分类
    private String classId;
    //文档地址
    private String url;
    //文档 开始时间
    private Data agentStarttime;


    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContentbody() {
        return contentbody;
    }

    public void setContentbody(String contentbody) {
        this.contentbody = contentbody;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Data getAgentStarttime() {
        return agentStarttime;
    }

    public void setAgentStarttime(Data agentStarttime) {
        this.agentStarttime = agentStarttime;
    }
}
