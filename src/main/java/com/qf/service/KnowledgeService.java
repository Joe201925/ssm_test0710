package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Classes;
import com.qf.bean.Knowledge;

import java.util.List;
import java.util.Map;

public interface KnowledgeService {

    PageInfo<Knowledge> findall(int index, int size,Knowledge knowledge);

    List<Classes> getall();

    int addknow(Knowledge knowledge);

    Knowledge findbyid(int id);

    int update(Knowledge knowledge);

    int delete(int id);
}
