<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
       $(function(){
           $("form").submit(function(){
               //验证信息
            var str=$("[name='classid']").val();
               if (str=='请选择'){
                   alert("请选择分类");
                   return false;
               }

           var  title=$("[name='title']").val();
               if ($.trim(title).length == 0){
                   alert("请填写标题");
                   return false;
               }

               var content=$("[name='content']").val();
               if ($.trim(content).length == 0){
                   alert("请输入内容");
                   return false;
               }

               return true;
           });
       })

    </script>

</head>

<body>
<div>
<center>
<h2>添加新条目</h2>

    <form action="/add" method="post">
    分类:<select name="classid">
        <option>请选择</option>
           <c:forEach items="${classes}" var="cla">
             <option value="${cla.id}">${cla.cname}</option>
           </c:forEach>
           </select><br>
        标题:<input type="text" name="title"><br>
        内容:<textarea rows="5" cols="20" name="content"></textarea>
    <input type="submit" value="保存">
        <input type="reset" value="重置">
        <input type="button" value="放弃">
    </form>
</center>
</div>
</body>
</html>