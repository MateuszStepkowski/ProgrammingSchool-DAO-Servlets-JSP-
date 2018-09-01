<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 01.09.18
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exercise Manager</title>
</head>
<body>

<h4>Add new exercise:</h4>
<form action="/adminPanel/exerciseAdd" method="post">
    <label>
        title:
        <input type="text" name="title">
    </label></br>
    <label>
        description:
        <input type="text" name="description">
    </label></br>
    <input type="submit">
</form>

<table>
    <tr>
        <th>exercise ID</th>
        <th>title</th>
        <th>description</th>
        <th colspan="2">actions on exercise</th>


    </tr>
    <c:forEach var="exercise"  items="${allExercises}">
        <tr>
            <td>${exercise.id}</td>
            <td>${exercise.title}</td>
            <td>${exercise.description}</td>
            <td> <a href="<c:url value="/adminPanel/exerciseEdit"/>?exerciseID=${exercise.id}"> edit </a> </td>
            <td> <a href="<c:url value="/adminPanel/exerciseDelete"/>?exerciseID=${exercise.id}"> delete </a> </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
