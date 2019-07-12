package com.qf.web;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Classes;
import com.qf.bean.Knowledge;
import com.qf.service.KnowledgeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@Controller
public class KnowledgeController {

    @Resource
    private KnowledgeService knowledgeService;


    /**
     * 查询所有知识库
     *
     */
    @RequestMapping("/findall")
    public String  findallitems(ModelMap map,@RequestParam(defaultValue = "1") int index, @RequestParam(defaultValue = "1")int size,Knowledge knowledge){

        //1.调用service方法

        System.out.println("++++"+knowledge.getTitle());

        PageInfo<Knowledge> pageInfo = knowledgeService.findall(index, 3, knowledge);

         map.addAttribute("pageinfo",pageInfo);
         map.addAttribute("tit",knowledge.getTitle());
         map.addAttribute("list",pageInfo.getList());

        return "showall";
    }

    /**
     * 查询所有分类
     */

    @RequestMapping("/getclasses")
    public String getallclasses(ModelMap map){

        List<Classes> classes = knowledgeService.getall();
       map.addAttribute("classes",classes);

        return "add";
    }

    /**
     * 增加条目
     */
    @RequestMapping("/add")
    public void add(Knowledge knowledge, HttpServletResponse response){

        knowledge.setLastmodified(new Date());
        //调用service方法

        int i = knowledgeService.addknow(knowledge);
        response.setContentType("text/html; charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();

            if (i>0){
               writer.print("<script>alert('增加成功');location.href='findall'</script>");
            }else {
                writer.print("<script>alert('增加失败');location.href='getclasses'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 主键查询
     */
    @RequestMapping("/findbyid")
    public String findbyid(int id,ModelMap map){
        List<Classes> classes = knowledgeService.getall();
        Knowledge knowledge = knowledgeService.findbyid(id);

        map.addAttribute("classes",classes);
       map.addAttribute("knowledge",knowledge);

        return "update";
    }

    /**
     * 保存修改
     */
    @RequestMapping("/update")
    public void update(Knowledge knowledge,HttpServletResponse response){

        knowledge.setLastmodified(new Date());
        int i = knowledgeService.update(knowledge);
        response.setContentType("text/html; charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();
            if (i>0){
                writer.print("<script>alert('修改成功');location.href='findall'</script>");
            }else {
                writer.print("<script>alert('修改失败');location.href='findbyid'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 删除
     */

    @RequestMapping("/deletebyid")
    private void delete(int id, HttpServletResponse response){

        int i = knowledgeService.delete(id);
        response.setContentType("text/html; charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();
            if (i>0){
                writer.print("<script>alert('删除成功');location.href='findall'</script>");
            }else {
                writer.print("<script>alert('删除失败');location.href='findbyid'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
