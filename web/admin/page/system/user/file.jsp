<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body><%--这里的两个值一定要设置成method="post" enctype="multipart/form-data"--%>
    <form action="file?action=toFile"  method="post" enctype="multipart/form-data">
        用户名：<input type="text" name="uname" value=""><br>
        密码：<input type="password" name="password" value=""><br>
        头像：<input type="file" name="file" value=""><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
