<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <c:if test="${empty pedido}">
         <h1>Su pedido ha sido Cancelado!</h1>
        </c:if>
        <section>
            <c:if test="${not empty pedido}">
                <h1>Su pedido ha sido realizado!</h1>
                <h2>Contenido de su pedido</h2>
                    <c:forEach items="${pedido}" var="detallePedido">
                        <article class="card comida shadow">
                            <div class="card-body">
                                <h3 class="card-title bebas">${detallePedido.plato.nombre}</h3>
                                <h5>${detallePedido.plato.TIPO_PLATO}</h5>
                                <p class="card-text">${detallePedido.plato.descripcion}</p>
                                <h5 class="card-title mt-2"><b>Restaurante: </b>${detallePedido.plato.restaurante.nombre}
                                </h5>
                                <h5 class="card-title mt-2"><b>Localidad: </b>${detallePedido.plato.restaurante.localidad}
                                </h5>
                                <h5 class="card-title mt-2"><b>Precio: </b>${detallePedido.plato.precio}</h5>
                            </div>
                        </article>
                    </c:forEach>
            </c:if>
            </br></br><a href="home">Ir a Home</a></br></br>
        </section>
    </div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>