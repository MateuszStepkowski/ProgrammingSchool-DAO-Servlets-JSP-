<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 01.09.18
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>Add new user:</h4>
<form action="/adminPanel/userAdd" method="post">
    <label>
        username:
        <input type="text" name="username">
    </label></br>
    <label>
        email:
        <input type="text" name="email">
    </label></br>
    <label>
        password:
        <input type="password" name="password">
    </label></br>
    <label>
        user group:
        <input type="number" name="group">
    </label></br>
    <input type="submit">
</form>

<table>
    <thead>
    <tr>
        <th>User ID</th>
        <th>username</th>
        <th colspan="2">actions on user</th>
    </tr>
    </thead>
    <tbody>


    <c:forEach var="user" items="${allUsers}">
        <tr>
            <td> <a href="<c:url value="/userDetails"/>?userID=${user.id}">${user.id}</a> </td>
            <td> ${user.username} </td>
            <td> <a href="<c:url value="/adminPanel/userEdit"/>?userID=${user.id}"> edit </a> </td>
            <td> <a href="<c:url value="/adminPanel/userDelete"/>?userID=${user.id}"> delete </a> </td>
        </tr>
    </c:forEach>


    </tbody>
</table>

</body>
</html>
