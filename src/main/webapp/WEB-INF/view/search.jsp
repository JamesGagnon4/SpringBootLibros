
<%--
  Created by IntelliJ IDEA.
  User: jgagnon
  Date: 9/29/20
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Search</title>
    <meta charset="UTF-8">
</head>
<body>

<h1>James Gagnon Memorial Library Search</h1>
You are currently logged in as ${username} <br>
<form action="" th:action="@{/search}" method="post">
    <p>
        Search our collection: <input type="text" name = "sr">
    </p>

    <p>

        <input type="submit" value="Submit">
        <strong><a href="book">View</a></strong><br>
        <a href="viewCart">View Your Cart</a>


    </p>
</form>

</body>
