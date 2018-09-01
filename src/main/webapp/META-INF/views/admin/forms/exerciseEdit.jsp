<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 01.09.18
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exercise Edit</title>
</head>
<body>

<h4>Edit exercise:</h4>
<form action="/adminPanel/exerciseEdit" method="post">
    <label>
        title:
        <input type="text" name="title">
    </label></br>
    <label>
        description:
        <input type="text" name="description">
    </label></br>

    <input type="hidden" name="exerciseID" value="${exerciseID}">
    <input type="submit">
</form>

</body>
</html>
