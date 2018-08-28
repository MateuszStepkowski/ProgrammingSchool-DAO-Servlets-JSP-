<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 18.08.18
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Groups</title>
</head>
<body>

<%@include file="default/links.jsp"%>

<h1>All Groups:</h1>

<table>
    <thead>
    <tr>
        <th>group ID</th>
        <th>group name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="group" items="${groups}">
        <tr>
            <td><a href="<c:url value="/groupDetails"/>?groupID=${group.id}"> ${group.id} </a></td>
            <td> ${group.name} </td>
        </tr>
    </c:forEach>
    </tbody>

</table>

</body>
</html>
