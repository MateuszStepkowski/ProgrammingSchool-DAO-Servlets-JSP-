<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 01.09.18
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Groups Manager</title>
</head>
<body>

<h4>Add new group:</h4>
<form action="/adminPanel/groupAdd" method="post">
    <label>
        Group name:
        <input type="text" name="name">
    </label>
    <input type="submit">
</form>


<table>
    <tr>
        <th>group ID</th>
        <th>name</th>
        <th colspan="2">actions on group</th>
    </tr>
    <tbody>
    <c:forEach var="group" items="${allGroups}">
    <tr>
        <td><a href="<c:url value="/groupDetails"/>?groupID=${group.id}"> ${group.id} </a></td>
        <td> ${group.name} </td>
        <td> <a href="<c:url value="/adminPanel/groupEdit"/>?groupID=${group.id}"> edit </a> </td>
        <td> <a href="<c:url value="/adminPanel/groupDelete"/>?groupID=${group.id}"> delete </a> </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
