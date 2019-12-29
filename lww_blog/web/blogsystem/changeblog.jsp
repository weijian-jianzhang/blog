<%--<jsp:useBean id="blog" scope="request" type="com.stx.entity.Blog"/>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    </style>
</head>
<body>
<script>
    window.onload=function (ev) {
        var main = document.getElementById("main");
        var myblog = document.getElementById("myblog");
        // main.classList.remove("active");
        myblog.classList.add("active")
    }
</script>
<div class="container">
    <%@ include file="/blogsystem/other/head.jsp"%>
    <br>
    <br>
    <br>

    <form action="/blogServlet?cast=changeblog" onsubmit="return check();" class="form-x form-tips"><div class="form-group" id="f_1573264708381">
        <input type="hidden" name="cast" value="changeblog"/>
        <div class="label">
            <label for="f_txt">
                博客标题
            </label>
        </div>
        <div class="field">
            <input type="text" class="input" id="blogTitle" name="blogTitle" maxlength="50" value="${blog.blogTitle}" size="50" data-validate="required:请填写博客名" placeholder="请填写博客名">
        </div>
        <br> <br><br>
    </div><div class="form-group" id="f_1573264767406">
        <div class="label">
            <label for="f_like_txt">
                分类
            </label>
        </div>

        <div class="field">
            <div class="button-group radio">
                <label class="button">
                    <input name="type" value="创作" type="radio" data-validate="required:请选择一个分类,radio:博客分类">创作
                </label>
                <label class="button">
                    <input name="type" value="生活" type="radio" data-validate="required:请选择一个分类,radio:博客分类">生活
                </label>
                <label class="button">
                    <input name="type" value="学习" type="radio" checked="checked" data-validate="required:请选择一个分类,radio:博客分类">学习
                </label>
            </div>
        </div>
    </div>
        <br><div class="form-group" id="f_1573265009494">
        <div class="label">
            <label for="f_address_txt">
                博客内容
            </label>
        </div>
        <div class="field">
            <textarea type="text" class="input" id="blogText" name="blogText" maxlength="5000" ROWS="20" value="" data-validate="required:请填写博客内容" placeholder="请填写博客内容"></textarea>
            <script>
                document.getElementById("blogText").value="${blog.blogText}";
            </script>
        </div>
    </div>
            <input type="submit" class="button bg-lx" style="margin-left: 60%"/>
        </form>



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
    function check() {
        var blogtxt = document.getElementById("blogText");
        var blogtile = document.getElementById("blogTitle");
        if (blogtxt.value.length>0&&blogtile.value.length>0){
            return true;
        }
    }
</script>
<%@ include file="/blogsystem/other/foot.jsp"%>
</body>
</html>
