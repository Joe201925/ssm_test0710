package com.qf.bean;

import java.util.List;

public class Classes {
    private Integer id;

    private String cname;

    private List<Knowledge> knowledgeList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }
}