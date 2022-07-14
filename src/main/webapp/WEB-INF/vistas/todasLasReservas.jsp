<%@ include file="header.jsp"%>


<style>
    <%@include file="/css/style.css"%>
</style>
<div class="container-general resto-container mt-1">
    <h3 class="title-valorado">Reservas de todos los Clientes</h3>
    <c:forEach items="${reservas}" var="reserva">
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">Reserva: N°${reserva.id}</h5>
                <p class="card-text">Mesa: ${reserva.mesa.id} - ${reserva.mesa.restaurante.nombre}</p>
                    <%--                <a href="#" class="btn btn-danger">Eliminar</a>--%>
                <form action="/proyecto_limpio_spring_war_exploded/todasLasReservas/${reserva.id}" method="post">
                    <button class="btn btn-danger" type="submit"  style="color: #cecece;">Eliminar</button>
                </form>
            </div>
        </div>
    </c:forEach>
</div>
<section class="testimonials text-center bg-light" style="margin-top: 50px;">
    <div class="container">
        <h2 class="mb-5">What people are saying...</h2>
        <div class="row">
            <div class="col-lg-4">
                <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                    <img class="rounded-circle mb-3 mw-50" src="https://startbootstrap.github.io/startbootstrap-landing-page/assets/img/testimonials-2.jpg" alt="..."  style="max-width: 50%;"/>
                    <h5>Margaret E.</h5>
                    <p class="font-weight-light mb-0">"This is fantastic! Thanks so much guys!"</p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                    <img class="rounded-circle mb-3 mw-50" src="https://startbootstrap.github.io/startbootstrap-landing-page/assets/img/testimonials-1.jpg" alt="..." style="max-width: 50%;"/>
                    <h5>Fred S.</h5>
                    <p class="font-weight-light mb-0">"Bootstrap is amazing. I've been using it to create lots of super nice landing pages."</p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                    <img class="rounded-circle mb-3 mw-50" src="https://startbootstrap.github.io/startbootstrap-landing-page/assets/img/testimonials-3.jpg" alt="..." style="max-width: 50%;"/>
                    <h5>Sarah W.</h5>
                    <p class="font-weight-light mb-0">"Thanks so much for making these free resources available to us!"</p>
                </div>
            </div>
        </div>
    </div>
</section>
<%@ include file="footer.jsp"%>