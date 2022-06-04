<%--
  Created by IntelliJ IDEA.
  User: rodrigo
  Date: 29/5/22
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Platos mas Vendidos</title>
</head>
<body>
<h1>lISTA DE PLATOS MAS VENDIDOS</h1>
<section >
    <c:forEach items="${platos}" var="plato">

        <article class="card comida shadow">
            <div class="card-body">
                <h3 class="card-title bebas">${plato.nombre}</h3>
                <p>${plato.TIPO_PLATO}</p>
                <p class="card-text">${plato.descripcion}</p>
                <p class="card-title mt-2"><b>Restaurante: </b>${plato.restaurante.nombre}</p>
                <p class="card-title mt-2"><b>Precio: </b>${plato.precio}</p>
            </div>
        </article>
    </c:forEach>
</section>
</body>
</html>
