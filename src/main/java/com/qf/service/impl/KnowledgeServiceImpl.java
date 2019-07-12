package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.bean.Classes;
import com.qf.bean.Knowledge;
import com.qf.dao.ClassesMapper;
import com.qf.dao.KnowledgeMapper;
import com.qf.service.KnowledgeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    @Resource
    private KnowledgeMapper knowledgeMapper;

    @Resource
    private ClassesMapper classesMapper;

    /**
     * 查询所有条目
     * @param index
     * @param size
     * @param knowledge
     * @return
     */
    @Override
    public PageInfo<Knowledge> findall(int index, int size,Knowledge knowledge) {
        PageHelper.startPage(index, size);
        Map map=new HashMap();


     /*   map.put("index",index);*/
     /*   map.put("size",size);*/
//        map.put("title",title);

        List<Knowledge> knowledges = knowledgeMapper.findall(knowledge);
        for (Knowledge k : knowledges) {
            System.out.println(k.getTitle());
        }
        PageInfo<Knowledge> pageInfo=new PageInfo<>(knowledges);

       if (pageInfo!=null){
          return pageInfo;
      }

        return null;
    }

    /**
     * 查询所有分类
     * @return
     */
    @Override
    public List<Classes> getall() {
        List<Classes> findclasses = classesMapper.findclasses();
        if (findclasses!=null){
            return findclasses;
        }
        return null;
    }

    /**
     * 增加知识条目
     * @param knowledge
     * @return
     */
    @Override
    @Transactional
    public int addknow(Knowledge knowledge) {

        int i = knowledgeMapper.insert(knowledge);

        return i;
    }

    /**
     * 主键查询
     * @param id
     * @return
     */
    @Override
    public Knowledge findbyid(int id) {

        return knowledgeMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新保存
     * @param knowledge
     * @return
     */
    @Override
    @Transactional
    public int update(Knowledge knowledge) {

        return knowledgeMapper.updateByPrimaryKey(knowledge);
    }

    /**
     * 删除条目
     * @param id
     * @return
     */
    @Override
    @Transactional
    public int delete(int id) {
        return knowledgeMapper.deleteByPrimaryKey(id);
    }
}
