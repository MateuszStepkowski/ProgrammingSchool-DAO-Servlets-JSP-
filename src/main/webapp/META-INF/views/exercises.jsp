<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 18.08.18
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exercises</title>
</head>
<body>

<%@include file="default/links.jsp"%>

<h1>All Exercises:</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="exercise" items="${exercises}">
        <tr>
            <td><a href="<c:url value="/exerciseDetails"/>?exerciseID=${exercise.id}"> ${exercise.id} </a>  </td>
            <td> ${exercise.title} </td>
            <td> ${exercise.description} </td>
        </tr>
    </c:forEach>
    </tbody>

</table>

</body>
</html>
