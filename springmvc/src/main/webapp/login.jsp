<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>
<head>
    <title>login</title>
</head>
<body>
<h2>welcome, please login first!</h2>

<%
    Object loginFailure = request.getAttribute("shiroLoginFailure");
    if (null != loginFailure) {
        String exception = loginFailure.toString();
        if (exception.equals("org.apache.shiro.authc.IncorrectCredentialsException")) {
            request.setAttribute("errorMsg", "error password");
        }
        if (exception.equals("org.apache.shiro.authc.UnknownAccountException")) {
            request.setAttribute("errorMsg", "username not exists");
        }
    }

%>
<strong style="color: red;">${errorMsg}</strong>

<form action="" method="post">
    username：<input type="text" name="username"><br/>
    password：<input type="password" name="password"><br/>
    <input type="submit" value="login">
</form>

</body>
</html>
