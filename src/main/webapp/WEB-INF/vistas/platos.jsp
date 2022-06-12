<%--
  Created by IntelliJ IDEA.
  User: Eduar
  Date: 15/5/2022
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>PLATOS</title>
</head>
<body>
<c:forEach items="${plato}" var="plato">

    <article class="card comida shadow">
        <p>${plato.nombre}</p>
    </article>
</c:forEach>


<h3>${cantidadPlatos}</h3>
</body>
</html>
