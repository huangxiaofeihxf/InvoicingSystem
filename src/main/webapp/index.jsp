<%--
  Created by IntelliJ IDEA.
  User: Huangxiaofei
  Date: 2018/8/17
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
   <script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="/js/login.js"></script>
    <script type="text/javascript">
       var loginError=$("l_span").lang;
     //  alert(loginError);

    </script>
</head>
<body>
<h1>小型进销存系统</h1>
<form action="/user/login" method="post">
    用户名:<input type="text" name="userName" id="u_name"/>
    密码：<input type="text" name="password" id="p_pwd"/>
    <input type="submit" value="登陆" id="f_submit" onclick="Testlogin()"/>
</form>
<span id="l_span" lang="${requestScope.loginError}"></span>
</body>
</html>
