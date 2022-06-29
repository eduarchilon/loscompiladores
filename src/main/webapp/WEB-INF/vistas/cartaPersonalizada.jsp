<%@ include file="header.jsp"%>

<style>
    <%@include file="/css/style.css"%>
</style>

    <h3 class="title-valorado">Nuestra carta personalizada para vos</h3>
<div class="resto-container">
<c:forEach items="${platos}" var="plato">


    <div class="card" style="width: 18rem;">
        <img src="https://i0.wp.com/www.recetaslily.com/wp-content/uploads/2019/09/01c87a16290b45c5b8eb75d3d1b52c6b.jpg?resize=525%2C351&ssl=1" class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">${plato.nombre}</h5>
            <p class="card-text">${plato.TIPO_PLATO}</p>
            <p class="card-text">${plato.descripcion}</p>
            <p class="card-text">Restaurante: ${plato.restaurante.nombre}</p>
            <p class="card-text">Precio: ${plato.precio}</p>
            <a href="#" class="btn btn-primary">Agregar al pedido</a>
        </div>
    </div>

</c:forEach>
</div>
<%@ include file="footer.jsp"%>
