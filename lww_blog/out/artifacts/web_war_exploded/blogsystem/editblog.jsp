
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>凌霄博客</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/pintuer.css"/>
    <style>
        .foooot{
            position: absolute;
            left: 32%;
            bottom: 0;
        }
        td{
            width: 200px;
        }

    </style>
</head>
<body>
<div class="container">
    <%@ include file="/blogsystem/other/head.jsp"%>

    <table class="table table-hover">
        <caption><h1>博客管理</h1></caption>
        <tr>
            <th>博客序号</th>
            <th>博客标题</th>
            <th>发表日期</th>
            <th>博客类型</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${blogList}" var="blog" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${blog.blogTitle}</td>
                <td>${blog.createTime}</td>
                <td>${blog.type}</td>
                <td><a href="/blogServlet?bid=${blog.blogId}&cast=change">修改</a>|<a href="/blogServlet?cast=deleteblog&id=${blog.blogId}">删除</a></td>
            </tr>
        </c:forEach>
    </table>

</div>
<script type="text/javascript" src="<%=basePath%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/pintuer.js"></script>
<script>
    window.onload=function (ev) {
        var myblog = document.getElementById("myblog");
        myblog.className="active";
    }
    function aboutus() {
        alert("凌霄一部");
    }
    function exitlogin() {
        window.location.href="/userServlet?cast=exit";
    }
</script>
<%@ include file="/blogsystem/other/foot.jsp"%>
</body>
</html>
