<%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 2/11/2018
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Filter</title>
</head>
<body>
filter

<form action="/pagination" method="get">

    <input name="name" type="text"/>
    <input list="${requestScope.language}" name="language"/>
    <input type="number" min="0" max="21" value="0" step="1" name="ageRestrictions">
    <input type="number" min="0" value="0" name="cost">

</form>

</body>
</html>
