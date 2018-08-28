<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 17.08.18
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Solution Details</title>
</head>
<body>

<%@include file="default/links.jsp"%>

<h1>Solution Details:</h1>
<div>
    Solution ID: ${solution.id} | Author: <a href="<c:url value="/userDetails"/>?userID=${solution.user.id}">${solution.user.username}</a><br>
    Created: ${solution.created} | Updated: ${solution.updated}<br>
    Exercise: <a href="<c:url value="/exerciseDetails"/>?exerciseID=${solution.exercise.id}">${solution.exercise.title}</a><br>
    Description:  ${solution.description}
</div>

</body>
</html>
