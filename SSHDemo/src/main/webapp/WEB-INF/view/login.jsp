<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2015/8/1
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="${website}login" method="post">
    <div class="login-header"><h3>登录</h3></div>
    <div class="login-content">
        <div class="login-content-inputButton">
            <label>用户名</label>
            <input type="text" name="username"  class="login-content-input" />
        </div>
        <div class="login-content-inputButton">
            <label>密　码</label>
            <input type="password" name="password" class="login-content-input">
        </div>
        <span class="error-tip">${error}</span>
        <div class="login-content-inputButton button">
            <input type="submit" value="登录" class="btn">
            <input type="reset" value="取消"  class="btn">
        </div>
    </div>
</form>

</body>
</html>
