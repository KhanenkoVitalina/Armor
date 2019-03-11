<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08.03.2019
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"   uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" scope="request"/>
<fmt:setBundle basename="strings" />
<html lang="${language}">
<head>
    <title></title>
    <style>
        button{
            border-radius: 12px;
            font-size: 20px;
            padding: 10px 20px;
            background-color: aliceblue;
            font-family: "Times New Roman", Times, serif;
        }
        .lan{
            font-family: "Times New Roman", Times, serif;
        }
        .categories{
            font-family: "Palatino Linotype", serif;
            alignment: center;
            font-size: medium;
        }
    </style>
</head>
<body>
<div class="lan" style="text-align:center">
    <a href="list?language=en">EN</a>|
    <a href="list?language=ru">RU</a>
</div>
<div style="text-align:right" style="margin-right: 100px" style="color: saddlebrown">
    <a href="list?basket=true"><fmt:message key="strings.basket"/></a>
</div>
<button onclick="location.href='/'"><fmt:message key="strings.back"/></button>
</br>
<div class="categories" style="text-align: center">
    <a href="list?armor=bow"><fmt:message key="strings.bow"/></a>
    <a href="list?armor=sword"><fmt:message key="strings.sword"/></a>
    <a href="list?armor=shield"><fmt:message key="strings.shield"/></a>
</div>

    </br>
    <c:forEach items="${list_of_armor}" var="item">
        <form method="get">
            <div class="list" style="text-align: center">
        <h3><fmt:message key="strings.${item.getName()}"/></h3>
            <input type="hidden" name="obj_name" value="${item.getName()}"/>
        <fmt:message key="strings.weight"/> : ${item.getWeight()}
            <input type="hidden" name="obj_weight" value="${item.getWeight()}"/>
        <br/>
        <fmt:message key="strings.material"/> : ${item.getMaterial()}
            <input type="hidden" name="obj_price" value="${item.getPrice()}"/>
        <br/>
        <c:if test="${item.getName() == 'bow'}">
            <fmt:message key="strings.accuracy"/> : ${item.getAccuracy()}
            <input type="hidden" name="obj_additional" value="${item.getAccuracy()}"/>
        </c:if>
        <c:if test="${item.getName() == 'sword'}">
            <fmt:message key="strings.sharpness"/> : ${item.getSharpness()}
            <input type="hidden" name="obj_additional" value="${item.getSharpness()}"/>
        </c:if>
        <c:if test="${item.getName() == 'shield'}">
            <fmt:message key="strings.protection"/> : ${item.getProtection()}
            <input type="hidden" name="obj_additional" value="${item.getProtection()}"/>
        </c:if>
            <input type = "submit" value = "<fmt:message key="strings.choose"/>"/>
            </div>
        </form>
        <br/>
    </c:forEach>
</body>
</html>
