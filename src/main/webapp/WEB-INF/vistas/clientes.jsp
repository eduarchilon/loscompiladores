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
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
  </head>
  <body>



<div class="navbar navbar-default">
  <h1>Clientes</h1>
  <ul class="nav nav-pills nav-justified">
    <li role="presentation"><a href="buscarPlatosMasVendidos">platos mas vendidos</a></li>
    <li role="presentation"><a href="ir-a-busqueda-plato">buscar platos</a></li>
    <li role="presentation"><a href="carta-personalizada">carta personalizada</a></li>
    <li role="presentation" class="active"><a href="ver-clientes">ver clientes</a></li>
  </ul>
</div>

  <c:forEach items="${clientes}" var="cliente">

    <article class="container jumbotron">
      <a href="ver-pedido-cliente/${cliente.nombre}">${cliente.nombre} ${cliente.apellido}</a>
    </article>

  </c:forEach>

  <h1>${buscado.nombre}</h1>
<c:forEach items="${pedidos}" var="pedido">

  <article class="card comida shadow">
    <p>PEDIDO NRO: P100${pedido.id}</p>
    <a href="ver-platos-del-pedido/${pedido.id}">Ver Detalle</a>
    <p>--------</p>
  </article>
</c:forEach>

<c:forEach items="${platosPedidos}" var="plato">

  <article class="card comida shadow">
    <p>${plato}</p>
    <p>--------</p>
  </article>
</c:forEach>

  </body>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
  <script src="js/bootstrap.min.js" type="text/javascript"></script>
</html>
