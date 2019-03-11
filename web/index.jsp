<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.03.2019
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Choose equipment for a knight!</title>
    <style>
      body{
        background-image: url("knight.gif");
        background-repeat:no-repeat;
      }
      button{
        border-radius: 12px;
        font-size: 20px;
        padding: 15px 32px;
        background-color: aliceblue;
        font-family: "Times New Roman", Times, serif;
        position: absolute;
        top: 50%;
      }
    </style>
  </head>
  <body>
  <div style="text-align: center">
    <button onclick="location.href='/list'">Get started</button>
  </div>
  </body>
</html>
