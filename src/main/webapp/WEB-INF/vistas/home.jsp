<%@ include file="header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
                <h5>Los mejores platos</h5>
                <a href=""><button type="button" class="btn btn-success px-5 fs-5 fw-bolder my-3">Ver platos de mi gusto</button></a>
                <p>Tenemos los mejores platos para ofrecerte sin importar el gusto que tengas. Vos sos libre de elegir.</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="https://www.bacanal.com.ar/wp-content/uploads/2017/05/ASADO-VEGGIE-VA2.jpg" class="d-block w-100" alt="..." style="height: 550px; object-fit: cover;">
            <div class="carousel-caption-bg d-none d-md-block text-slider">
                <h5>Los mejores locales de comida</h5>
                <a href="/proyecto_limpio_spring_war_exploded/todasLasReservas"><button type="button" class="btn btn-danger px-5 fs-5 fw-bolder my-3">Ver reservas</button></a>
                <p>Tenemos una lista de los mejores locales de comida para que esten cerca de donde estes</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="https://saboryestilo.com.mx/wp-content/uploads/2020/03/kit-basico-para-tu-parrillada-1-1200x720.jpg" class="d-block w-100" alt="..." style="height: 550px; object-fit: cover;">
            <div class="carousel-caption-bg d-none d-md-block text-slider">
                <h5>Los mejores precios</h5>
                <a href="/proyecto_limpio_spring_war_exploded/restaurantes"><button type="button" class="btn btn-warning px-5 fs-5 fw-bolder my-3">Ver todos los restaurantes</button></a>
                <p>No te preocupes por los precios. Tenemos los mejores precios adaptados a tu bolsillo.</p>
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
            <a href="platos-del-restaurante/${valorado.id}" class="card-link">Ver platos</a>
            <a href="${valorado.id}/mesas" class="card-link">Reservar mesas</a>
        </div>
    </div>

</c:forEach>
</div>

<%@ include file="footer.jsp"%>