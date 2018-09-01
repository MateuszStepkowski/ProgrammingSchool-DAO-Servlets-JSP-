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
    <title>Group Edit</title>
</head>
<body>

<h4>Edit group:</h4>
<form action="/adminPanel/groupEdit" method="post">
    <label>
        Group name:
        <input type="text" name="name">
    </label>

    <input type="hidden" name="groupID" value="${groupID}">

    <input type="submit">
</form>

</body>
</html>
