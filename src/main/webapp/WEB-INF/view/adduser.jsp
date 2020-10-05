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
<body>
<h2>Add new User</h2>
<form action="" th:action="@{/adduser" method="post">
    <p>
        Enter user name: <input type="text" name = "un" value = "Guest">
    </p>
    Enter password: <input type="text" name = "pw" value = "Default">
    <p>

        <input type="submit" value="Submit"><br>
        <a href="login">Return to Log in</a> <br>
    <h2> ${test}</h2>


    </p>
</form>
</body>
</html>
