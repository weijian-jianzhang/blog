<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>凌霄会员</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/pintuer.css"/>
    <script type="text/javascript" src="<%=basePath%>/js/jquery.js"></script>
    <script type="text/javascript" src="<%=basePath%>/js/pintuer.js"></script>

</head>
<body>
<div class="container">
    <%@include file="other/head.jsp" %>
    <div class="keypoint bg radius text-center">
        <h1>
            尊贵的凌霄用户，您好！！！</h1>
        <p>
            轻快 愉悦的充值体验<br>
            全新的充值中心为您而来

        <p>
            <button id="chong" class="button bg-lx text-center">
                我已充值
            </button>
        </p>
    </div>
    <center>
    <img src="${pageContext.request.contextPath}/img/wx.jpg" alt="" width="240px" height="320px">
    <img src="${pageContext.request.contextPath}/img/zfb.jpg" alt="" width="240px" height="320px"></center>
    <%@include file="other/foot.jsp"%>
</div>
<script>
    document.getElementById("chong").onclick=function (ev) {
        alert("充值失败！");
    }
    function aboutus() {
        alert("凌霄一部");
    }
</script>
</body>
</html>
