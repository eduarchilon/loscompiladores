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
            <a href="/proyecto_limpio_spring_war_exploded/ver-plato/${plato.id}" class="card-link">Ver plato</a>
            <form action="/proyecto_limpio_spring_war_exploded/agregar-plato/${plato.id}" method="post">
                <button type="submit" class="btn btn-primary">Agregar al pedido</button>
            </form>
        </div>
    </div>

</c:forEach>
</div>



<%@ include file="footer.jsp"%>
