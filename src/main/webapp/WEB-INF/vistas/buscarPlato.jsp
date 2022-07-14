<%@ include file="header.jsp"%>

<style>
    <%@include file="/css/style.css"%>
</style>
<div class="container">
    <div style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <form:form action="buscar-plato" method="POST" modelAttribute="formBuscarPlato">
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
            <button id="btn-registrarme" class="btn btn-lg btn-primary btn-block" Type="Submit"/>
            Buscar</button>
            </br><hr class="colorgraph"><br>
        </form:form>

        <form:form action="mostrar-pedido" method="POST">
            <input type="text" hidden name="idCliente" value="1">
            <button type="submit" class="btn btn-secondary btn-sm ">Mostrar pedido</button>
        </form:form>

        <c:if test="${not empty pedido}">
            <h1>Pedido</h1>

            <c:forEach items="${pedido}" var="detallePedido">
                <form:form action="mostrar-pedido" method="POST">
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
                            <input type="text" hidden name="idPlatoElegido" value="${detallePedido.getId_detallePlato()}">
                            <input type="text" hidden name="nombrePlatoElegido" value="${detallePedido.plato.nombre}">
                            <input type="text" hidden name="descripcionPlatoElegido" value="${detallePedido.plato.descripcion}">
                            <input type="text" hidden name="nombreRestauranteElegido" value="${detallePedido.plato.restaurante.nombre}">
                            <input type="text" hidden name="localidadRestauranteElegido" value="${detallePedido.plato.restaurante.localidad}">
                            <input type="text" hidden name="precioPlatoELegido" value="${detallePedido.plato.precio}">
                            <input type="text" hidden name="idCliente" value="1">
                            <button type="submit" class="btn btn-secondary btn-sm">Quitar del pedido</button>
                        </div>
                    </article>
                </form:form>
            </c:forEach>
            </br> </br>
            <form:form action="realizar-pedido" method="POST">
                <!-- el controlador va a capturar el id de cliente y confirmar que todos los platos van al pedido. eliminar los datos de
                detalepedidos correspondientes al pedido -->
                <input type="text" hidden name="idCliente" value="1">
                </br>
                <button type="submit" class="btn btn-secondary btn-sm ">Realizar pedido</button>
            </form:form>
            <form:form action="cancelar-pedido" method="get">
                <input type="search" hidden name="idCliente" value="1">
                <br>
                <button type="submit" class="btn btn-secondary btn-sm ">Cancelar pedido</button>
            </form:form>
        </c:if>

        </br>
        <hr class="colorgraph">
        <br>
        <c:if test="${not empty error}">
            <h4><span>${error}</span></h4>
            <br>
        </c:if>
        <c:if test="${not empty isAgregado}">
            <h4><span>${isAgregado}</span></h4>
            <br>
        </c:if>
        <section>
            <c:if test="${empty formBuscarPlato.precio && not empty formBuscarPlato.nombrePlato && empty formBuscarPlato.localidadRestaurante}">
                <c:forEach items="${platos}" var="plato">
                    <form:form action="agregar-plato" method="POST" modelAttribute="formBuscarPlato">
                        <article class="card comida shadow">
                            <div class="card-body">
                                <h3 class="card-title bebas">${plato.nombre}</h3>
                                <h5>${plato.TIPO_PLATO}</h5>
                                <p class="card-text">${plato.descripcion}</p>
                                <h5 class="card-title mt-2"><b>Restaurante: </b>${plato.restaurante.nombre}</h5>
                                <h5 class="card-title mt-2"><b>Localidad: </b>${plato.restaurante.localidad}</h5>
                                <h5 class="card-title mt-2"><b>Precio: </b>${plato.precio}</h5>


                                <input type="text" hidden name="nombrePlatoElegido" value="${plato.nombre}">
                                <input type="text" hidden name="descripcionPlatoElegido" value="${plato.descripcion}">
                                <input type="text" hidden name="nombreRestauranteElegido"
                                       value="${plato.restaurante.nombre}">
                                <input type="text" hidden name="localidadRestauranteElegido"
                                       value="${plato.restaurante.localidad}">
                                <input type="text" hidden name="precioPlatoELegido" value="${plato.precio}">
                                <input type="text" hidden name="idCliente" value="1">
                                <form action="/proyecto_limpio_spring_war_exploded/agregar-plato/${plato.id}" method="post">
                                    <button type="submit" class="btn btn-primary">Agregar al pedido</button>
                                </form>
                            </div>
                            </br>
                        </article>
                    </form:form>
                </c:forEach>
            </c:if>
            <c:if test="${not empty formBuscarPlato.precio && empty formBuscarPlato.nombrePlato && empty formBuscarPlato.localidadRestaurante}">
                <c:forEach items="${platosConFiltroPrecio}" var="plato">
                    <form:form action="agregar-plato" method="POST">
                        <article class="card comida shadow">
                            <div class="card-body">
                                <h3 class="card-title bebas">${plato.nombre}</h3>
                                <h5>${plato.TIPO_PLATO}</h5>
                                <p class="card-text">${plato.descripcion}</p>
                                <h5 class="card-title mt-2"><b>Restaurante: </b>${plato.restaurante.nombre}</h5>
                                <h5 class="card-title mt-2"><b>Localidad: </b>${plato.restaurante.localidad}</h5>
                                <h5 class="card-title mt-2"><b>Precio: </b>${plato.precio}</h5>

                                <input type="text" hidden name="nombrePlatoElegido" value="${plato.nombre}">
                                <input type="text" hidden name="descripcionPlatoElegido" value="${plato.descripcion}">
                                <input type="text" hidden name="nombreRestauranteElegido"
                                       value="${plato.restaurante.nombre}">
                                <input type="text" hidden name="localidadRestauranteElegido"
                                       value="${plato.restaurante.localidad}">
                                <input type="text" hidden name="precioPlatoELegido" value="${plato.precio}">
                                <input type="text" hidden name="idCliente" value="1">
                                <form action="/proyecto_limpio_spring_war_exploded/agregar-plato/${plato.id}" method="post">
                                    <button type="submit" class="btn btn-primary">Agregar al pedido</button>
                                </form>
                            </div>
                        </article>
                    </form:form>
                </c:forEach>
            </c:if>
            <c:if test="${not empty formBuscarPlato.precio && not empty formBuscarPlato.nombrePlato && empty formBuscarPlato.localidadRestaurante}">
                <c:forEach items="${platosConFiltroPrecioYNombre}" var="plato">
                    <form:form action="agregar-plato" method="POST">
                        <article class="card comida shadow">
                            <div class="card-body">
                                <h3 class="card-title bebas">${plato.nombre}</h3>
                                <h5>${plato.TIPO_PLATO}</h5>
                                <p class="card-text">${plato.descripcion}</p>
                                <h5 class="card-title mt-2"><b>Restaurante: </b>${plato.restaurante.nombre}</h5>
                                <h5 class="card-title mt-2"><b>Localidad: </b>${plato.restaurante.localidad}</h5>
                                <h5 class="card-title mt-2"><b>Precio: </b>${plato.precio}</h5>

                                <input type="text" hidden name="nombrePlatoElegido" value="${plato.nombre}">
                                <input type="text" hidden name="descripcionPlatoElegido" value="${plato.descripcion}">
                                <input type="text" hidden name="nombreRestauranteElegido"
                                       value="${plato.restaurante.nombre}">
                                <input type="text" hidden name="localidadRestauranteElegido"
                                       value="${plato.restaurante.localidad}">
                                <input type="text" hidden name="precioPlatoELegido" value="${plato.precio}">
                                <input type="text" hidden name="idCliente" value="1">
                                <form action="/proyecto_limpio_spring_war_exploded/agregar-plato/${plato.id}" method="post">
                                    <button type="submit" class="btn btn-primary">Agregar al pedido</button>
                                </form>
                            </div>
                        </article>
                    </form:form>
                </c:forEach>
            </c:if>
            <c:if test="${not empty formBuscarPlato.precio && not empty formBuscarPlato.nombrePlato && not empty formBuscarPlato.localidadRestaurante}">
                <c:forEach items="${platosConFiltroPrecioNombreYLocalidad}" var="plato">
                    <form:form action="agregar-plato" method="POST">
                        <article class="card comida shadow">
                            <div class="card-body">
                                <h3 class="card-title bebas">${plato.nombre}</h3>
                                <h5>${plato.TIPO_PLATO}</h5>
                                <p class="card-text">${plato.descripcion}</p>
                                <h5 class="card-title mt-2"><b>Restaurante: </b>${plato.restaurante.nombre}</h5>
                                <h5 class="card-title mt-2"><b>Localidad: </b>${plato.restaurante.localidad}</h5>
                                <h5 class="card-title mt-2"><b>Precio: </b>${plato.precio}</h5>

                                <input type="text" hidden name="nombrePlatoElegido" value="${plato.nombre}">
                                <input type="text" hidden name="descripcionPlatoElegido" value="${plato.descripcion}">
                                <input type="text" hidden name="nombreRestauranteElegido"
                                       value="${plato.restaurante.nombre}">
                                <input type="text" hidden name="localidadRestauranteElegido"
                                       value="${plato.restaurante.localidad}">
                                <input type="text" hidden name="precioPlatoELegido" value="${plato.precio}">
                                <input type="text" hidden name="idCliente" value="1">
                                <form action="/proyecto_limpio_spring_war_exploded/agregar-plato/${plato.id}" method="post">
                                    <button type="submit" class="btn btn-primary">Agregar al pedido</button>
                                </form>
                            </div>
                        </article>
                    </form:form>
                </c:forEach>
            </c:if>
            <c:if test="${empty formBuscarPlato.precio && not empty formBuscarPlato.nombrePlato &&  not empty formBuscarPlato.localidadRestaurante}">
                <c:forEach items="${platosConFiltroNombreYLocalidad}" var="plato">
                    <form:form action="agregar-plato" method="POST">
                        <article class="card comida shadow">
                            <div class="card-body">
                                <h3 class="card-title bebas">${plato.nombre}</h3>
                                <h5>${plato.TIPO_PLATO}</h5>
                                <p class="card-text">${plato.descripcion}</p>
                                <h5 class="card-title mt-2"><b>Restaurante: </b>${plato.restaurante.nombre}</h5>
                                <h5 class="card-title mt-2"><b>Localidad: </b>${plato.restaurante.localidad}</h5>
                                <h5 class="card-title mt-2"><b>Precio: </b>${plato.precio}</h5>

                                <input type="text" hidden name="nombrePlatoElegido" value="${plato.nombre}">
                                <input type="text" hidden name="descripcionPlatoElegido" value="${plato.descripcion}">
                                <input type="text" hidden name="nombreRestauranteElegido"
                                       value="${plato.restaurante.nombre}">
                                <input type="text" hidden name="localidadRestauranteElegido"
                                       value="${plato.restaurante.localidad}">
                                <input type="text" hidden name="precioPlatoELegido" value="${plato.precio}">
                                <input type="text" hidden name="idCliente" value="1">
                                <form action="/proyecto_limpio_spring_war_exploded/agregar-plato/${plato.id}" method="post">
                                    <button type="submit" class="btn btn-primary">Agregar al pedido</button>
                                </form>
                            </div>
                        </article>
                    </form:form>
                </c:forEach>
            </c:if>
            <c:if test="${not empty formBuscarPlato.precio && empty formBuscarPlato.nombrePlato &&  not empty formBuscarPlato.localidadRestaurante}">
                <c:forEach items="${platosConFiltroPrecioYLocalidad}" var="plato">
                    <form:form action="agregar-plato" method="POST">
                        <article class="card comida shadow">
                            <div class="card-body">
                                <h3 class="card-title bebas">${plato.nombre}</h3>
                                <h5>${plato.TIPO_PLATO}</h5>
                                <p class="card-text">${plato.descripcion}</p>
                                <h5 class="card-title mt-2"><b>Restaurante: </b>${plato.restaurante.nombre}</h5>
                                <h5 class="card-title mt-2"><b>Localidad: </b>${plato.restaurante.localidad}</h5>
                                <h5 class="card-title mt-2"><b>Precio: </b>${plato.precio}</h5>

                                <input type="text" hidden name="nombrePlatoElegido" value="${plato.nombre}">
                                <input type="text" hidden name="descripcionPlatoElegido" value="${plato.descripcion}">
                                <input type="text" hidden name="nombreRestauranteElegido"
                                       value="${plato.restaurante.nombre}">
                                <input type="text" hidden name="localidadRestauranteElegido"
                                       value="${plato.restaurante.localidad}">
                                <input type="text" hidden name="precioPlatoELegido" value="${plato.precio}">
                                <input type="text" hidden name="idCliente" value="1">
                                <form action="/proyecto_limpio_spring_war_exploded/agregar-plato/${plato.id}" method="post">
                                    <button type="submit" class="btn btn-primary">Agregar al pedido</button>
                                </form>
                            </div>
                        </article>
                    </form:form>
                </c:forEach>
            </c:if>
            <c:if test="${not empty formBuscarPlato.precio && empty formBuscarPlato.nombrePlato &&  not empty formBuscarPlato.localidadRestaurante}">
                <c:forEach items="${platosConFiltroPrecioYLocalidad}" var="plato">
                    <form:form action="agregar-plato" method="POST">
                        <article class="card comida shadow">
                            <div class="card-body">
                                <h3 class="card-title bebas">${plato.nombre}</h3>
                                <h5>${plato.TIPO_PLATO}</h5>
                                <p class="card-text">${plato.descripcion}</p>
                                <h5 class="card-title mt-2"><b>Restaurante: </b>${plato.restaurante.nombre}</h5>
                                <h5 class="card-title mt-2"><b>Localidad: </b>${plato.restaurante.localidad}</h5>
                                <h5 class="card-title mt-2"><b>Precio: </b>${plato.precio}</h5>

                                <input type="text" hidden name="nombrePlatoElegido" value="${plato.nombre}">
                                <input type="text" hidden name="descripcionPlatoElegido" value="${plato.descripcion}">
                                <input type="text" hidden name="nombreRestauranteElegido"
                                       value="${plato.restaurante.nombre}">
                                <input type="text" hidden name="localidadRestauranteElegido"
                                       value="${plato.restaurante.localidad}">
                                <input type="text" hidden name="precioPlatoELegido" value="${plato.precio}">
                                <input type="text" hidden name="idCliente" value="1">
                                <form action="/proyecto_limpio_spring_war_exploded/agregar-plato/${plato.id}" method="post">
                                    <button type="submit" class="btn btn-primary">Agregar al pedido</button>
                                </form>
                            </div>
                        </article>
                    </form:form>
                </c:forEach>
            </c:if>
            <c:if test="${empty formBuscarPlato.precio && empty formBuscarPlato.nombrePlato &&  not empty formBuscarPlato.localidadRestaurante}">
                <c:forEach items="${platosConFiltroLocalidad}" var="plato">
                    <form:form action="agregar-plato" method="POST">
                        <article class="card comida shadow">
                            <div class="card-body">
                                <h3 class="card-title bebas">${plato.nombre}</h3>
                                <h5>${plato.TIPO_PLATO}</h5>
                                <p class="card-text">${plato.descripcion}</p>
                                <h5 class="card-title mt-2"><b>Restaurante: </b>${plato.restaurante.nombre}</h5>
                                <h5 class="card-title mt-2"><b>Localidad: </b>${plato.restaurante.localidad}</h5>
                                <h5 class="card-title mt-2"><b>Precio: </b>${plato.precio}</h5>

                                <input type="text" hidden name="nombrePlatoElegido" value="${plato.nombre}">
                                <input type="text" hidden name="descripcionPlatoElegido" value="${plato.descripcion}">
                                <input type="text" hidden name="nombreRestauranteElegido"
                                       value="${plato.restaurante.nombre}">
                                <input type="text" hidden name="localidadRestauranteElegido"
                                       value="${plato.restaurante.localidad}">
                                <input type="text" hidden name="precioPlatoELegido" value="${plato.precio}">
                                <input type="text" hidden name="idCliente" value="1">
                                <form action="/proyecto_limpio_spring_war_exploded/agregar-plato/${plato.id}" method="post">
                                    <button type="submit" class="btn btn-primary">Agregar al pedido</button>
                                </form>
                            </div>
                        </article>
                    </form:form>
                </c:forEach>
            </c:if>
        </section>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<%@ include file="footer.jsp"%>