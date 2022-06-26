<%--
  Created by IntelliJ IDEA.
  User: Eduar
  Date: 26/6/2022
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <title>YourRestoNearYou</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light container-general">
    <div class="container-fluid">
        <img src="https://cdn.icon-icons.com/icons2/2419/PNG/512/restaurant_location_icon_146860.png" alt="" width="60px">
        <a class="navbar-brand" href="/proyecto_limpio_spring_war_exploded/home">YourRestoNearYou</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link" href="/proyecto_limpio_spring_war_exploded/buscarPlatosMasVendidos">Platos mas vendidos</a>
                <a class="nav-link" href="/proyecto_limpio_spring_war_exploded/ir-a-busqueda-plato">Buscar platos</a>
                <a class="nav-link" href="/proyecto_limpio_spring_war_exploded/carta-personalizada">Carta personalizada</a>
                <a class="nav-link" href="/proyecto_limpio_spring_war_exploded/ver-clientes">Clientes</a>
            </div>
        </div>
    </div>
</nav>

<%--<main>--%>

