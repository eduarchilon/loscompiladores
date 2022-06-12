<%--
  Created by IntelliJ IDEA.
  User: Eduar
  Date: 7/6/2022
  Time: 01:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<h1>Clientes</h1>

  <c:forEach items="${clientes}" var="cliente">

    <article class="card comida shadow">
      <p>${cliente.nombre} ${cliente.apellido}</p>
    </article>
  </c:forEach>
  </body>
</html>
