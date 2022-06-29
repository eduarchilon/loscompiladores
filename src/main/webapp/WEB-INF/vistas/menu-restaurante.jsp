<%@ include file="header.jsp"%>

<style>
    <%@include file="/css/style.css"%>
</style>


<h3 class="title-valorado">${resto.nombre}</h3>

<div class="resto-container">
<c:forEach items="${platosRestaurante}" var="plato">

    <div class="card" style="width: 18rem;">
        <img src="https://i.blogs.es/1d2f94/1366_2000-15-/450_1000.webp" class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">${plato.nombre}</h5>
            <p class="card-text">${plato.descripcion}</p>
            <p class="card-text">Precio: $${plato.precio}</p>
        </div>
    </div>

</c:forEach>
</div>



<%@ include file="footer.jsp"%>
