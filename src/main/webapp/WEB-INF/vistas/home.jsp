<%--
  Created by IntelliJ IDEA.
  User: Eduar
  Date: 25/6/2022
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>

<body>
<nav class="navbar navbar-expand-lg bg-light container-general">
    <div class="container-fluid">
        <img src="https://cdn.icon-icons.com/icons2/2419/PNG/512/restaurant_location_icon_146860.png" alt="" width="60px">
        <a class="navbar-brand" href="/home">YourRestoNearYou</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link" href="buscarPlatosMasVendidos">Platos mas vendidos</a>
                <a class="nav-link" href="ir-a-busqueda-plato">Buscar platos</a>
                <a class="nav-link" href="carta-personalizada">Carta personalizada</a>
                <a class="nav-link" href="ver-clientes">Clientes</a>
            </div>
        </div>
    </div>
</nav>

<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="false">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="https://imagekit.androidphoria.com/wp-content/uploads/platos-veganos.jpg" class="d-block w-100" alt="..." style="height: 550px; object-fit: cover;">
            <div class="carousel-caption-bg d-none d-md-block text-slider">
                <h5>First slide label</h5>
                <p>Some representative placeholder content for the first slide.</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="https://www.bacanal.com.ar/wp-content/uploads/2017/05/ASADO-VEGGIE-VA2.jpg" class="d-block w-100" alt="..." style="height: 550px; object-fit: cover;">
            <div class="carousel-caption-bg d-none d-md-block text-slider">
                <h5>Second slide label</h5>
                <p>Some representative placeholder content for the second slide.</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="https://saboryestilo.com.mx/wp-content/uploads/2020/03/kit-basico-para-tu-parrillada-1-1200x720.jpg" class="d-block w-100" alt="..." style="height: 550px; object-fit: cover;">
            <div class="carousel-caption-bg d-none d-md-block text-slider">
                <h5>Third slide label</h5>
                <p>Some representative placeholder content for the third slide.</p>
            </div>
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>

<h3 class="title-valorado">Nuestros restaurantes recomendados para vos</h3>
<p class="text-valorado">Estos son los resturantes mas valorados por nuestros clientes. Animate a experimentar la misma sensación que sintieron ellos al probar cada uno de sus platos.</p>

<div class="container-general resto-container">
<c:forEach items="${restosValorados}" var="valorado">
    <div class="card" style="width: 18rem;">
        <img src="https://i.pinimg.com/originals/d5/ec/9c/d5ec9c42cade6c696ef244cc33efedd3.gif" class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">${valorado.nombre}</h5>
            <p class="card-text">Tenemos los mejores platos de la zona a un solo click de ditancia.</p>
        </div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">Dirección: ${valorado.direccion}</li>
            <li class="list-group-item">Telefono: ${valorado.telefono}</li>
            <li class="list-group-item">Calificacion: ${valorado.calificacion}✪</li>
        </ul>
        <div class="card-body">
            <a href="#" class="card-link">Ver platos</a>
            <a href="#" class="card-link">Reservar mesas</a>
        </div>
    </div>

</c:forEach>
</div>



<footer class="text-center text-white" style="background-color: #f1f1f1;">
    <!-- Grid container -->
    <div class="container pt-4 container-general">
        <!-- Section: Social media -->
        <section class="mb-4">
            <!-- Facebook -->
            <a
                    class="btn btn-link btn-floating btn-lg text-dark m-1"
                    href="#!"
                    role="button"
                    data-mdb-ripple-color="dark"
            ><i class="fa fa-facebook"></i
            ></a>

            <!-- Twitter -->
            <a
                    class="btn btn-link btn-floating btn-lg text-dark m-1"
                    href="#!"
                    role="button"
                    data-mdb-ripple-color="dark"
            ><i class="fa fa-twitter"></i
            ></a>

            <!-- Google -->
            <a
                    class="btn btn-link btn-floating btn-lg text-dark m-1"
                    href="#!"
                    role="button"
                    data-mdb-ripple-color="dark"
            ><i class="fa fa-google"></i
            ></a>

            <!-- Instagram -->
            <a
                    class="btn btn-link btn-floating btn-lg text-dark m-1"
                    href="#!"
                    role="button"
                    data-mdb-ripple-color="dark"
            ><i class="fa fa-instagram"></i
            ></a>

            <!-- Linkedin -->
            <a
                    class="btn btn-link btn-floating btn-lg text-dark m-1"
                    href="#!"
                    role="button"
                    data-mdb-ripple-color="dark"
            ><i class="fa fa-linkedin"></i
            ></a>
            <!-- Github -->
            <a
                    class="btn btn-link btn-floating btn-lg text-dark m-1"
                    href="#!"
                    role="button"
                    data-mdb-ripple-color="dark"
            ><i class="fa fa-github"></i
            ></a>
        </section>
        <!-- Section: Social media -->
    </div>
    <!-- Grid container -->

    <!-- Copyright -->
    <div class="text-center text-dark p-3" style="background-color: rgba(0, 0, 0, 0.2);">
        © 2022 Copyright:
        <a class="text-dark" href="https://mdbootstrap.com/">Taller Web I - UNLaM</a>
    </div>
    <!-- Copyright -->
</footer>

<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>

</body>
</html>
