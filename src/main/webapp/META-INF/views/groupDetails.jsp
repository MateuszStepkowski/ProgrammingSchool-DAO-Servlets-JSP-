<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 18.08.18
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GroupDetails</title>
</head>
<body>

<%@include file="default/links.jsp"%>

<h1>Group Details</h1>
<h3>Group name: ${group.name}  | ID:${group.id}</h3>

<hr>

<h2>All Users from this Group:</h2>
<table>
    <thead>
    <tr>
        <th>user ID</th>
        <th>username</th>
        <th>e-mail</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${groupUsers}">
        <tr>
            <td><a href="<c:url value="/userDetails"/>?userID=${user.id}">${user.id}</a></td>
            <td> ${user.username} </td>
            <td> ${user.email} </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
