<%@ include file="header.jsp" %>

<style>
    <%@include file="/css/style.css"%>
</style>


<div class="container-general resto-container mt-1">

    <div class="card mb-3 mt-5">
        <img class="card-img-top"
             src="https://images-ext-2.discordapp.net/external/fYTuiz9yUIYvULN372rWKlDrnRozu3GRD4LUdoBDlsc/https/jumboalacarta.com.ar/wp-content/uploads/2019/06/shutterstock_521741356-1024x684.jpg?width=1012&height=676"
             alt="Card image cap" style="height: 200px;">
        <div class="card-body">
            <h5 class="card-title">${platoBuscado.nombre}</h5>
            <p class="card-text">${platoBuscado.descripcion}</p>
            <p class="card-text"><small class="text-muted">${platoBuscado.precio}</small></p>
            <p class="about">${platoBuscado.tipo.nombre}</p>
            <h6 class="about">Restaurante: ${platoBuscado.restaurante.nombre}</h6>
            <div class="cart mt-4 align-items-center">
                <form action="/proyecto_limpio_spring_war_exploded/agregar-plato/${platoBuscado.id}" method="post">
                    <button type="submit" class="btn btn-primary">Agregar al pedido</button>
                </form>
                </br>

            </div>
        </div>
    </div>
</div>
<h4 class="title-valorado mb-3">Adicionales:</h4>
<div class="container-general resto-container mt-1">
    <div class="container-general resto-container">
        <c:forEach items="${adicionales}" var="adicional">
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">${adicional.nombre}</h5>
                    <p class="card-text">$${adicional.precio}</p>
                    <form action="/proyecto_limpio_spring_war_exploded/agregar-adicional/${adicional.id}" method="post">
                        <button type="submit" class="btn btn-primary">Agregar adicional</button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</br> <p class="title-valorado">Precio final: $${PrecioFinal}</p> </br>

<script>
    function change_image(image) {

        var container = document.getElementById("main-image");

        container.src = image.src;
    }

    document.addEventListener("DOMContentLoaded", function (event) {

    });
</script>

<%@ include file="footer.jsp" %>