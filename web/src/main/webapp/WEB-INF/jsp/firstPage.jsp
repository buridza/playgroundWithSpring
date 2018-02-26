<%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 1/20/2018
  Time: 11:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:set var="currentPage" scope="session" value="1"/>
<form id="filter" action="/pagination" method="get">

    <br>Название игры: <input name="name" type="text" value="${requestScope.name}"/>
    <br>Язык игры: <input list="language" name="language" value="${requestScope.language}" aria-dropeffect="popup"/>
    <datalist id="language">
        <option>RUSSIAN</option>
        <option>ENGLISH</option>
        <option>GERMAN</option>
        <option>FRENCH</option>
    </datalist>
    <br>Возрастное ограничение: <input type="number" min="0" value="${requestScope.age}" step="1"
                                       name="ageRestrictions">
    <br>Стоимость: <input type="number" min="0" value="${requestScope.cost}" name="cost" step="1">
    <input type="submit">

    <br><br>
    Количество записей: <input name="numberOfRows" type="number" min="5" max="50" step="5"
                               value="${requestScope.currentNumberOfRows}">
    <c:if test="${requestScope.currentPage > 1}">
        <button type="submit" name="nextPage" value="${currentPage-1}">${requestScope.get("currentPage")-1}</button>
    </c:if>
    <button type="submit" name="nextPage" value="${currentPage}" >${requestScope.get("currentPage")}</button>
    <button type="submit" name="nextPage" value="${currentPage+1}">${requestScope.get("currentPage")+1}</button>
    <button type="submit" name="nextPage" value="${currentPage+2}">${requestScope.get("currentPage")+2}</button>
    <button type="submit" name="nextPage" value="${currentPage+3}">${requestScope.get("currentPage")+3}</button>
    <button type="submit" name="nextPage" value="${currentPage+4}">${requestScope.get("currentPage")+4}</button>

</form>
<table border="1">
    <tr>
        <td id="name">Название</td>
        <td id="rules">Правила</td>
        <td id="cost">Стоимость</td>
        <td id="age">Возрастное ограничение</td>
        <td id="number">Количество игроков</td>
        <td id="lang">Язык</td>
        <td id="provider">Издатель</td>
    </tr>
    <c:forEach items="${requestScope.allGames}" var="game">
        <tr>

            <td width="15" headers="name"><c:out value="${game.name}"/></td>
            <td width="15" headers="rules"><c:out value="${game.rules}"/></td>
            <td width="15" headers="cost"><c:out value="${game.cost}"/></td>
            <td width="15" headers="age"><c:out value="${game.ageRestrictions}"/></td>
            <td width="15" headers="number"><c:out value="${game.numberOfPlayers}"/></td>
            <td width="15" headers="lang"><c:out value="${game.language}"/></td>
            <td width="15" headers="provider"><c:out value="${game.provider.name}"/></td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
