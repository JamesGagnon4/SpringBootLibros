<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>ModelAttribute Example</title>
</head>
<body>
<h1>${pageContent.headerName}</h1>
<table border = "1">

    <tr>

        <th>Title</th>
        <th>Author</th>
        <th>Genre</th>
        <th>Price</th>
    </tr>

    <c:forEach var="Book" items="${Books}">
        <tr>
            <td><c:out value="${Book.getId}" /></td>
            <td><c:out value="${Book.title()}" /></td>
            <td><c:out value="${Book.authorName}" /></td>

            <td><c:out value="${Book.genre()}" /></td>

            <td><c:out value="${Book.price()}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
