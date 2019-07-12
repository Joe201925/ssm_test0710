package com.qf.dao;

import com.qf.bean.Knowledge;

import java.util.List;
import java.util.Map;

public interface KnowledgeMapper {

    // 根据id 删除
    int deleteByPrimaryKey(Integer id);

    // 添加书籍
    int insert(Knowledge record);

    int insertSelective(Knowledge record);

    // 根据id 主键查询
    Knowledge selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Knowledge record);

    // 修改书籍
    int updateByPrimaryKey(Knowledge record);

    //1.查询所有书籍
    List<Knowledge> findall(Knowledge knowledge);

    //3.添加书籍方法
    public int insertKnowledge(Knowledge knowledge);

    //4. 根据书籍主键查询
    Knowledge findbyid(int kid);

    //5. 修改书籍方法
    int updateKnowledge(Knowledge knowledge);

    //6.根据id 删除书籍
    int deleteKnowledge(int kid);

}