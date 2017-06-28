package com.ssm.demo.core.dto;

/**
 * Describe: description of this class
 * Author: ouym
 * Created Date: 2016/11/30.
 */
public class DocDto {

    //文档名称
    private String docName;
    //文档摘要
    private String docAbstract;
    //文档路径
    private String docPath;

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocAbstract() {
        return docAbstract;
    }

    public void setDocAbstract(String docAbstract) {
        this.docAbstract = docAbstract;
    }

    public String getDocPath() {
        return docPath;
    }

    public void setDocPath(String docPath) {
        this.docPath = docPath;
    }
}
