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
</head>
<body>
<div class="container">
    <%@ include file="/blogsystem/other/head.jsp"%>
    <c:forEach items="${allBlogList}" var="blog">
        <br>
        <div class="panel">
            <div class="panel-head" style="text-align: center">
                <a href="/blogServlet?blogId=${blog.blogId}&cast=showblogtext">${blog.blogTitle}&nbsp;&nbsp;&nbsp;&nbsp;类别：${blog.type}</a>
            </div>
            <div class="panel-body detail">
                <p class="text-left" style="padding-left: 10%">
                        ${blog.blogText}
                </p>
            </div>
            <div class="panel-foot">
                <div class="text-right">
                    <span style="color: red"><a href="/userServlet?cast=query&userid=${blog.user.id}">${blog.user.userName}</a></span>发布于${blog.createTime}
                </div>
            </div>
            <br>

        </div>
    </c:forEach>
</div>
<script type="text/javascript" src="<%=basePath%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/pintuer.js"></script>
<script>
    window.onload=function (ev) {
        var myblog = document.getElementById("blogcenter");
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
