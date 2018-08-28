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
    <title>ExerciseDetails</title>
</head>
<body>

<%@include file="default/links.jsp"%>

<h1>Exercise Details:</h1>
<h3>exercise ID: ${exercise.id}</h3>
<h3>Title: ${exercise.title}</h3>
<h3>Description:</h3>
<p>
    ${exercise.description}
</p>

<hr>

<h2>Exercise Solutions:</h2>
<table>
    <thead>
    <tr>
        <th>solution ID</th>
        <th>Author name</th>
        <th>Author ID</th>
        <th>created</th>
        <th>updated</th>
        <th>description</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="solution" items="${exerciseSolutions}">
        <tr>
            <td> ${solution.id} </td>
            <td> ${solution.user.username} </td>
            <td> ${solution.user.id} </td>
            <td> ${solution.created} </td>
            <td> ${solution.updated} </td>
            <td> ${solution.description} </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>
