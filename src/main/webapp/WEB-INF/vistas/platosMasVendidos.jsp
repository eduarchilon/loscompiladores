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
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>

<div class="navbar navbar-default">
    <h1>lISTA DE PLATOS MAS VENDIDOS</h1>
    <ul class="nav nav-pills nav-justified">
        <li role="presentation" class="active"><a href="buscarPlatosMasVendidos">platos mas vendidos</a></li>
        <li role="presentation"><a href="ir-a-busqueda-plato">buscar platos</a></li>
        <li role="presentation"><a href="carta-personalizada">carta personalizada</a></li>
        <li role="presentation"><a href="ver-clientes">ver clientes</a></li>
    </ul>
</div>
<section >
    <c:forEach items="${platos}" var="plato" varStatus="loop">

        <article class="card comida shadow">
            <div class="container jumbotron pl-5">
                <h3 class="card-title bebas">${loop.index} - ${plato.nombre}</h3>
                <p>${plato.TIPO_PLATO}</p>
                <p class="card-text">${plato.descripcion}</p>
                <p class="card-title mt-2"><b>Restaurante: </b>${plato.restaurante.nombre}</p>
                <p class="card-title mt-2"><b>Precio: </b>${plato.precio}</p>
            </div>
        </article>
    </c:forEach>
</section>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</html>
