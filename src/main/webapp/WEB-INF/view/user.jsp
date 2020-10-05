
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


<table border="1">
    <th>Sr No</th>
    <th>Name</th>
    <th>Password</th>


    <c:forEach var="user" items="${listUser}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${user.name()}</td>
            <td>${user.password()}</td>



        </tr>
    </c:forEach>
</table>

</body>
</html>