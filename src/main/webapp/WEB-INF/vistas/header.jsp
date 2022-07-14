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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://kit.fontawesome.com/2354d0be54.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>YourRestoNearYou</title>
</head>
<body>
<style>
    <%@include file="/css/style.css"%>
</style>
<nav class="navbar navbar-expand-lg bg-light navBar-ancho">
    <div class="container-fluid  container-general">
        <img src="https://i.pinimg.com/originals/bd/87/83/bd87839c22ba2ecc577a5c381f168dd4.jpg" alt="" width="70px">
        <a class="navbar-brand" href="/proyecto_limpio_spring_war_exploded/home">YourRestoNearYou</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse navbar-style" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link" href="/proyecto_limpio_spring_war_exploded/buscarPlatosMasVendidos">Platos mas vendidos</a>
                <a class="nav-link" href="/proyecto_limpio_spring_war_exploded/ir-a-busqueda-plato">Buscar platos</a>
                <a class="nav-link" href="/proyecto_limpio_spring_war_exploded/carta-personalizada">Carta personalizada</a>
                <a class="nav-link" href="/proyecto_limpio_spring_war_exploded/ver-clientes">Clientes</a>
                <a class="nav-link" href="/proyecto_limpio_spring_war_exploded/todasLasReservas">Todas Las Reservas</a>
                <a href="/proyecto_limpio_spring_war_exploded/cart"><button type="button" class="btn btn-primary rounded" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    <i class="fa fa-shopping-cart"></i> Cart
                </button></a>
            </div>
        </div>
    </div>
</nav>

<%--<main>--%>

