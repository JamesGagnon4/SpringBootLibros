
<%--
  Created by IntelliJ IDEA.
  User: jgagnon
  Date: 9/28/20
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<h2>Search Results:</h2>

<form action="" th:action="@{/book">
<table border="1">

    <th>Sr No</th>
    <th>Title</th>
    <th>Author</th>
    <th>Genre</th>
    <th>Price</th>
    <th>Add to Cart</th>



    <c:forEach items="${Books}" var="book" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${book.title()}</td>
            <td>${book.authorName}</td>
            <td>${book.genre()}</td>
            <td>${book.price()}</td>
            <td> <input type="submit" value="Add ${book.title()} to cart."></td>
        </tr>
        <input name="title" type="hidden" value="${book.title()}" />
        <input name="author" type="hidden" value="${book.authorName}" />
        <input name="genre" type="hidden" value="${book.genre()}" />
        <input name="price" type="hidden" value="${book.price()}" />

    </c:forEach>

</table>
    <a href="search">Return to Search</a> <br>
    <a href="/">Return to Index</a> <br>
    <a href="viewCart">View Your Cart</a>
</body>
</html>