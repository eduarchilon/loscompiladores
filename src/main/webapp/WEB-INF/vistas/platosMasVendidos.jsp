<%@ include file="header.jsp"%>

<style>
    <%@include file="/css/style.css"%>
</style>

<h3 class="title-valorado">Nuestros platos mas vendidos</h3>
<div class="container-general">
    <section class="resto-container">
        <c:forEach items="${platos}" var="plato" varStatus="loop">
            <div class="card" style="width: 18rem;">
                <img src="https://i0.wp.com/www.recetaslily.com/wp-content/uploads/2019/09/01c87a16290b45c5b8eb75d3d1b52c6b.jpg?resize=525%2C351&ssl=1" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">${loop.index} - ${plato.nombre}</h5>
                    <p class="card-text">${plato.TIPO_PLATO}</p>
                    <p class="card-text">${plato.descripcion}</p>
                    <p class="card-text">Restaurante: ${plato.restaurante.nombre}</p>
                    <p class="card-text">Precio: ${plato.precio}</p>
                    <a href="/proyecto_limpio_spring_war_exploded/ver-plato/${plato.id}" class="card-link">Ver plato</a>
                    <form action="" method="post">
                        <button type="submit" class="btn btn-primary">Agregar al pedido</button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </section>
</div>

<%@ include file="footer.jsp"%>
