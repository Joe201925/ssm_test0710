<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<body>
<div >
    <center>

    <h2>检索知识库</h2>

   <form action="/findall" method="post">
       关键字:<input type="text" name="title" value="${tit}">
       <input type="submit" value="提交">
   </form>

    <a href="/getclasses">添加条目</a>

    <h2>检索结果</h2>
        <form>
    <table border="2px" width="60%">

        <tr>
            <td align="center">序号</td>
            <td align="center">标题</td>
            <td align="center">分类</td>
            <td align="center">最后修改时间</td>
        </tr>

        <c:forEach items="${list}" var="page">
         <tr>
             <td align="center">${page.id}</td>
             <td align="center"><a href="findbyid?id=${page.id}">${page.title}</a></td>
             <td align="center">${page.classes.cname}</td>
             <td align="center"><fmt:formatDate value="${page.lastmodified}" timeStyle="yyyy-MM-dd hh-mm-ss"></fmt:formatDate></td>
         </tr>
     </c:forEach>
        <tr >
            <td align="center" colspan="4">
                <a href="findall?index=${pageinfo.firstPage}&title=${tit}">首页</a>
                <a href="findall?index=${pageinfo.prePage==0?1:pageinfo.prePage}&title=${tit}">上一页</a>
               <a href="findall?index=${pageinfo.nextPage==0?pageinfo.lastPage:pageinfo.nextPage}&title=${tit}">下一页</a>
                <a href="findall?index=${pageinfo.lastPage}&title=${tit}">尾页</a>
                第${pageinfo.pageNum}页/共${pageinfo.pages}页
            </td>
        </tr>

    </table>
</form>
    </center>
</div>
</body>
</html>