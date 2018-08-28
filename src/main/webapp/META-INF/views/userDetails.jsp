<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 18.08.18
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserDetails</title>
</head>
<body>

<%@include file="default/links.jsp"%>

<h1>User Details</h1>

<table>
    <thead>
    <tr>
        <th>user ID</th>
        <th>username</th>
        <th>e-mail</th>
        <th>group</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td> ${user.id} </td>
        <td> ${user.username} </td>
        <td> ${user.email} </td>
        <td> <a href="<c:url value="/groupDetails"/>?groupID=${user.userGroup.id}">${user.userGroup.id}</a> </td>
    </tr>
    </tbody>
</table>


<h3>User's Solutions:</h3>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>created</th>
        <th>updated</th>
        <th>description</th>
        <th>exercise ID</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="solution" items="${userSolutions}">
        <tr>
            <td> ${solution.id} </td>
            <td> ${solution.created} </td>
            <td> ${solution.updated} </td>
            <td> ${solution.description} </td>
            <td>  <a href="<c:url value="/exerciseDetails"/>?exerciseID=${solution.exercise.id}">${solution.exercise.id}</a> </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>
