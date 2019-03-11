<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.03.2019
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"   uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" scope="request"/>
<fmt:setBundle basename="strings" />
<html lang="${language}">
<html>
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
    </style>
</head>
<body>
<div style="text-align:center">
    <a href="list?language=en&basket=true">EN</a>|
    <a href="list?language=ru&basket=true">RU</a>
</div>
<button onclick="location.href='/'"><fmt:message key="strings.back"/></button>
<div  style="text-align: center">
<h3><fmt:message key="strings.find.in.diapason"/></h3>
<form action = "list" method = "get">
<input type = "text" name = "min_price"> -
<input type = "text" name = "max_price" />
    <input type="hidden" name="basket" value="true"/>
<input type = "submit" value = "<fmt:message key="strings.find"/>" />
</form>
<h2><fmt:message key="strings.sort.by.weight"/></h2>
<form>
<c:forEach items="${basket_list}" var="item">
    <h3><fmt:message key="strings.${item.getName()}"/></h3>
    <input type="hidden" name="obj_name" value="${item.getName()}"/>
    <fmt:message key="strings.weight"/> : ${item.getWeight()}
    <input type="hidden" name="obj_weight" value="${item.getWeight()}"/>
    <br/>
    <fmt:message key="strings.price"/> : ${item.getPrice()}
    <input type="hidden" name="obj_price" value="${item.getPrice()}"/>
        <input type="hidden" name="basket" value="true"/>
    <br/>
    <input  type = "submit" name="delete" value = "<fmt:message key="strings.delete"/>" />
</c:forEach>
</div>
</br>
    <h4><fmt:message key="strings.total.cost"/>  ${total_cost}</h4>
<h3><input type = "submit" name="buy" value = "<fmt:message key="strings.buy"/>"/></h3>
</form>
</body>
</html>
