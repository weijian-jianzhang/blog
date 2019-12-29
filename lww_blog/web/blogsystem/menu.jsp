<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>凌霄博客</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/pintuer.css"/>
    <script type="text/javascript" src="<%=basePath%>/js/jquery.js"></script>
    <script type="text/javascript" src="<%=basePath%>/js/pintuer.js"></script>
    <style>
        .foooot{
            position: absolute;
            left: 32%;
            bottom: 0;
        }
    </style>
</head>
<body>
<div class="container">
    <%@ include file="/blogsystem/other/head.jsp"%>


    <div class="keypoint bg radius text-center">
        <h1>
            凌霄博客</h1>
        <p>
            凌霄一部欢迎您一起交流学习。

        <p>
            <button id="love" class="button bg-lx text-center">
                加油</button>
        </p>
    </div>
    <div class="keypoint bg text-black" align="center">
        <img src="../img/凌霄一部.png" width="450" height="250">
    </div>
    <div class="popo">
        <div class="popo-left">
            <div class="popo-body popo-blue left box-shadow-big">希望你可以在我的博客系统里愉快遨游哦！</div>
        </div>
    </div>
    <div class="popo" >
        <div class="popo-right">
            <div class="ico-right "></div>
            <div class="popo-body popo-yellow right radius box-shadow-small">
                如果喜欢我，就请给我加油！
            </div>
        </div>
    </div>

</div>

<script>
    function tmcat(){
        window.location.href="https://blog.csdn.net/qq_40881680/article/details/83582484";
    }
    window.onload=function (ev) {
        var main = document.getElementById("main");
        main.classList.add("active")
    }
    var love = document.getElementById("love");
    love.onclick=function (ev) {
        alert("一起加油")
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
