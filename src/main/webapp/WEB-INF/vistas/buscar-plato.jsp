<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <form:form action="buscarPlato" method="POST" modelAttribute="formBuscarPlato">
            <h3 class="form-busqueda-heading">Buscar Comida</h3>
            <hr class="colorgraph">
            <br>

            <label for="nombrePlato">Nombre</label>
            <form:input path="nombrePlato" id="nombrePlato" class="form-control"/>
            <br>
            <h4 class="form-busqueda-heading">Filtros</h4>
            <label for="precio">Precio</label>
            <form:input path="precio" id="precio" class="form-control"/>
            <br>
            <label for="localidadRestaurante">Localidad del restaurante</label>
            <form:select path="localidadRestaurante" class="form-control">
                <form:option value="" label="Sin Filtro"/>
                <form:option value="Ramos Mejia" label="Ramos Mejia"/>
                <form:option value="San Justo" label="San Justo"/>
                <form:option value="Ciudadela" label="Ciudadela"/>
            </form:select>
            <br>
            <button id="btn-registrarme" class="btn btn-lg btn-primary btn-block" Type="Submit"/>Buscar</button>
            </br><hr class="colorgraph"><br>
        </form:form>

        <c:if test="${not empty error}">
            <h4><span>${error}</span></h4>
            <br>
        </c:if>
        <section>
            <c:if test="${empty formBuscarPlato.precio && not empty formBuscarPlato.nombrePlato && empty formBuscarPlato.localidadRestaurante}">
                <form:form action="" method="POST">
                    <c:forEach items="${platos}" var="plato">
                        <article class="card comida shadow">
                            <div class="card-body">
                                <h3 class="card-title bebas">${plato.nombre}</h3>
                                <h5>${plato.TIPO_PLATO}</h5>
                                <p class="card-text">${plato.descripcion}</p>
                                <h5 class="card-title mt-2"><b>Restaurante: </b>${plato.restaurante.nombre}</h5>
                                <h5 class="card-title mt-2"><b>Localidad: </b>${plato.restaurante.localidad}</h5>
                                <h5 class="card-title mt-2"><b>Precio: </b>${plato.precio}</h5>
                                <input type="submit" class="btn btn-secondary btn-sm " value="Agregar al pedido"></button>
                            </div>
                        </article>
                    </c:forEach>
                </form:form>
            </c:if>
            <c:if test="${not empty formBuscarPlato.precio && empty formBuscarPlato.nombrePlato && empty formBuscarPlato.localidadRestaurante}">
                <form:form action="" method="POST">
                    <c:forEach items="${platosConFiltroPrecio}" var="plato">
                        <article class="card comida shadow">
                            <div class="card-body">
                                <h3 class="card-title bebas">${plato.nombre}</h3>
                                <h5>${plato.TIPO_PLATO}</h5>
                                <p class="card-text">${plato.descripcion}</p>
                                <h5 class="card-title mt-2"><b>Restaurante: </b>${plato.restaurante.nombre}</h5>
                                <h5 class="card-title mt-2"><b>Localidad: </b>${plato.restaurante.localidad}</h5>
                                <h5 class="card-title mt-2"><b>Precio: </b>${plato.precio}</h5>
                                <input type="submit" class="btn btn-secondary btn-sm " value="Agregar al pedido"></button>
                            </div>
                        </article>
                    </c:forEach>
                </form:form>
            </c:if>
            <c:if test="${not empty formBuscarPlato.precio && not empty formBuscarPlato.nombrePlato && empty formBuscarPlato.localidadRestaurante}">
                <form:form action="" method="POST">
                    <c:forEach items="${platosConFiltroPrecioYNombre}" var="plato">
                        <article class="card comida shadow">
                            <div class="card-body">
                                <h3 class="card-title bebas">${plato.nombre}</h3>
                                <h5>${plato.TIPO_PLATO}</h5>
                                <p class="card-text">${plato.descripcion}</p>
                                <h5 class="card-title mt-2"><b>Restaurante: </b>${plato.restaurante.nombre}</h5>
                                <h5 class="card-title mt-2"><b>Localidad: </b>${plato.restaurante.localidad}</h5>
                                <h5 class="card-title mt-2"><b>Precio: </b>${plato.precio}</h5>
                                <input type="submit" class="btn btn-secondary btn-sm " value="Agregar al pedido"></button>
                            </div>
                        </article>
                    </c:forEach>
                </form:form>
            </c:if>
            <c:if test="${not empty formBuscarPlato.precio && not empty formBuscarPlato.nombrePlato && not empty formBuscarPlato.localidadRestaurante}">
                <form:form action="" method="POST">
                    <c:forEach items="${platosConFiltroPrecioNombreYLocalidad}" var="plato">
                        <article class="card comida shadow">
                            <div class="card-body">
                                <h3 class="card-title bebas">${plato.nombre}</h3>
                                <h5>${plato.TIPO_PLATO}</h5>
                                <p class="card-text">${plato.descripcion}</p>
                                <h5 class="card-title mt-2"><b>Restaurante: </b>${plato.restaurante.nombre}</h5>
                                <h5 class="card-title mt-2"><b>Localidad: </b>${plato.restaurante.localidad}</h5>
                                <h5 class="card-title mt-2"><b>Precio: </b>${plato.precio}</h5>
                                <input type="submit" class="btn btn-secondary btn-sm " value="Agregar al pedido"></button>
                            </div>
                        </article>
                    </c:forEach>
                </form:form>
            </c:if>
            <c:if test="${empty formBuscarPlato.precio && not empty formBuscarPlato.nombrePlato &&  not empty formBuscarPlato.localidadRestaurante}">
                <form:form action="" method="POST" >
                    <c:forEach items="${platosConFiltroNombreYLocalidad}" var="plato">
                        <article class="card comida shadow">
                            <div class="card-body">
                                <h3 class="card-title bebas">${plato.nombre}</h3>
                                <h5>${plato.TIPO_PLATO}</h5>
                                <p class="card-text">${plato.descripcion}</p>
                                <h5 class="card-title mt-2"><b>Restaurante: </b>${plato.restaurante.nombre}</h5>
                                <h5 class="card-title mt-2"><b>Localidad: </b>${plato.restaurante.localidad}</h5>
                                <h5 class="card-title mt-2"><b>Precio: </b>${plato.precio}</h5>
                                <input type="submit" class="btn btn-secondary btn-sm " value="Agregar al pedido"></button>
                            </div>
                        </article>
                    </c:forEach>
                </form:form>
            </c:if>
            <c:if test="${not empty formBuscarPlato.precio && empty formBuscarPlato.nombrePlato &&  not empty formBuscarPlato.localidadRestaurante}">
                <form:form action="" method="POST" >
                    <c:forEach items="${platosConFiltroPrecioYLocalidad}" var="plato">
                        <article class="card comida shadow">
                            <div class="card-body">
                                <h3 class="card-title bebas">${plato.nombre}</h3>
                                <h5>${plato.TIPO_PLATO}</h5>
                                <p class="card-text">${plato.descripcion}</p>
                                <h5 class="card-title mt-2"><b>Restaurante: </b>${plato.restaurante.nombre}</h5>
                                <h5 class="card-title mt-2"><b>Localidad: </b>${plato.restaurante.localidad}</h5>
                                <h5 class="card-title mt-2"><b>Precio: </b>${plato.precio}</h5>
                                <input type="submit" class="btn btn-secondary btn-sm " value="Agregar al pedido"></button>
                            </div>
                        </article>
                    </c:forEach>
            </form:form>
            </c:if>
        </section>
    </div>
</div>

<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>