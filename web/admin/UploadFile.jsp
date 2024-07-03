<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/4/18
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/user/action=Login" method="post" enctype="multipart/form-data">
        用户名：<input type="text" name="uname" value=""><br>
        密码：<input type="password" name="password" value=""><br>
        头像：<input type="file" name="file" value=""><br>
        <input type="submit" value="提交">
    </form>

</body>
</html>
