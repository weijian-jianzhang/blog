
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <style>
        .panel {
            width: 45%;
            height: 40%;
            position: absolute;
            top: 23%;
            left: 26%;
        }
        .text{
            height: 100%;
            width: 40%;

            position: relative;
            left: 8%;
            top:28%;
        }
        .right{
            border-left: 1px grey solid ;
            border-left-width: thin;
            height: 70%;
            width: 60%;
            position: absolute;
            left: 44%;
            top: 20%;
        }
        #cn{
            font-family: 幼圆;
            font-size: 65px;
            color: aqua;
        }
        #en{
            font-family: "Century Gothic";
            font-size: 35px;
            color: skyblue;
        }
        .bord{
            margin-left: 40px;
            width: 400px;
            height: 65px;
            border-radius: 8px;
            border-style: groove;
            position: relative;
            top: 10px;
            padding-left: 5%;
            font-size: 15px;
        }
        #subbtn{
            position: absolute;
            left: 32%;
            top:80%;
            width: 200px;
            height: 50px;
            background: aqua;
            border: 0;
            color: white;
            font-size: 17px;
            border-radius: 8px;
        }
        #subbtn:hover{
            background: skyblue;
        }
        a{
            position: relative;
            left: 40px;
            top:22px;
            color:aqua;
            text-decoration: none;
        }
        a:hover{
            color: skyblue;
            text-decoration: underline;
        }


    </style>
</head>
<body>
<div class="background">
    <div class="panel">
        <div class="text">
            <div id="cn">凌霄博客</div>
            <div id="en">Soaring sky blog</div>
        </div>
        <div class="right">
          <span>
        <form action="/userServlet">
            <input type="hidden" name="cast" value="login">
            <input type="text" name="userName" placeholder="请输入用户名" class="bord"><br><br>
            <input type="password" name="passWord" placeholder="请输入密码" class="bord"><br>
                    <a href="register.jsp" id="">没有账号？现在注册</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="forget.jsp">忘记密码</a>
            <input type="submit" value="登录" id="subbtn"><br>
        </form>


         </span>
        </div>

    </div>
</div>

</body>
</html>
