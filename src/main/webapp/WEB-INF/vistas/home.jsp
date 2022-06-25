<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <!-- <link href="css/bootstrap.min.css" rel="stylesheet" > -->
	    <!-- Bootstrap theme -->
	    <!-- <link href="css/bootstrap-theme.min.css" rel="stylesheet"> -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
	</head>
	<body>
		<nav class="navbar navbar-expand-lg bg-light">
			<div class="container-fluid">
			  <a class="navbar-brand" href="home">YourRestoNearYou</a>
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
				<img src="https://c4.wallpaperflare.com/wallpaper/775/107/619/buenos-aires-argentina-cafes-street-wallpaper-preview.jpg" class="d-block w-100" alt="..." style="height: 550px; object-fit: cover;">
				<div class="carousel-caption d-none d-md-block">
				  <h5>First slide label</h5>
				  <p>Some representative placeholder content for the first slide.</p>
				</div>
			  </div>
			  <div class="carousel-item">
				<img src="https://c0.wallpaperflare.com/preview/993/685/247/argentina-puerto-madero-street-buenos-aires.jpg" class="d-block w-100" alt="..." style="height: 550px; object-fit: cover;">
				<div class="carousel-caption d-none d-md-block">
				  <h5>Second slide label</h5>
				  <p>Some representative placeholder content for the second slide.</p>
				</div>
			  </div>
			  <div class="carousel-item">
				<img src="https://c4.wallpaperflare.com/wallpaper/918/237/227/aires-argentina-buenos-wallpaper-preview.jpg" class="d-block w-100" alt="..." style="height: 550px; object-fit: cover;">
				<div class="carousel-caption d-none d-md-block">
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
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
	</body>
</html>