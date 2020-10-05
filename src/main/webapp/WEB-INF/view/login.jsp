<%--
  Created by IntelliJ IDEA.
  User: jgagnon
  Date: 10/1/20
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in page</title>
</head>
You are currently logged in as ${username}
<body>
<form target="_self" action="/Result2" method="post">
    <p>
        Enter user name: <input type="text" name = "un">
    </p>
    Enter password: <input type="text" name = "pw">
    <p>

        <input onclick="window.location.href = '/Result2';"type="submit" value="Log In">



    </p>
</form>
<a href="/">Return to Index</a> <br>
</body>
</html>
