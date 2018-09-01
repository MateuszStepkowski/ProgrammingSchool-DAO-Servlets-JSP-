<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 01.09.18
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Users Manager --></h2>

<a href="<c:url value="/adminPanel/users"/> ">
    <h3>go forward</h3>
</a>
<h2>Groups Manager --></h2>

<a href="<c:url value="/adminPanel/groups"/> ">
    <h3>go forward</h3>
</a>


<h2>Exercises Manager --></h2>

<a href="<c:url value="/adminPanel/exercises"/> ">
    <h3>go forward</h3>
</a>
</body>
</html>
