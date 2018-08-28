<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 17.08.18
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
</head>
<body>

<%@include file="default/links.jsp"%>

<div>
    <table>

        <title>Recent solutions</title>

        <thead>
        <tr>
            <th>updated</th>
            <th>author</th>
            <th>task</th>
            <th>link</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${recentSolutions}" var="solution">
            <tr>
                <td>${solution.updated}</td>
                <td>${solution.user.username}</td>
                <td>${solution.exercise.title}</td>
                <td><a href="<c:url value="/solutionDetails"/>?solutionID=${solution.id}">more details</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
