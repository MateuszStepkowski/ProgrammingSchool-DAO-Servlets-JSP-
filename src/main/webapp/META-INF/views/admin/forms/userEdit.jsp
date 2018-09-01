<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 01.09.18
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User edit</title>
</head>
<body>

<h4>Edit user:</h4>
<form action="/adminPanel/userEdit" method="post">
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

    <input type="hidden" name="userID" value="${userID}">
    <input type="submit">
</form>

</body>
</html>
