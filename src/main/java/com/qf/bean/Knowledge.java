package com.qf.bean;

import java.util.Date;

public class Knowledge {
    private Integer id;

    private String title;

    private Date lastmodified;

    private String content;

    private Integer classid;

    private Classes classes;

/*    public Knowledge(Integer id, String title, Date lastmodified, String content, Integer classid, Classes classes) {
        this.id = id;
        this.title = title;
        this.lastmodified = lastmodified;
        this.content = content;
        this.classid = classid;
        this.classes = classes;
    }*/

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(Date lastmodified) {
        this.lastmodified = lastmodified;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }
}