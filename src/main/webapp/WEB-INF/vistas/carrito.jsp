<%@ include file="header.jsp"%>

<style>
    <%@include file="/css/style.css"%>
</style>

<h3 class="title-valorado">Carrito de compras</h3>
<div class="resto-container">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col">
                <div class="card">
                    <div class="card-body">

                        <div class="row">

                            <div class="col-lg-7">
                                <h5 class="mb-3"><a href="#!" class="text-body text-decoration-none"><i
                                        class="fas fa-long-arrow-alt-left me-2"></i>Seguir comprando</a></h5>

                                <!--TODOS LOS ITEMES-->
                                <div class="container-items">
                                    <c:forEach items="${platosCarrito}" var="carrito">
                                        <div class="card mb-3">
                                            <div class="card-body">
                                                <div class="d-flex justify-content-between">
                                                    <div class="d-flex flex-row align-items-center">
                                                        <div>
                                                            <img
                                                                    src="https://blog.taranna.com/docs/doce-platos-populares-mundo-taranna-013-620x413.jpg"
                                                                    class="img-fluid rounded-3" alt="Shopping item" style="width: 65px;">
                                                        </div>
                                                        <div class="ms-3">
                                                            <h5>${carrito.nombre}</h5>
                                                            <p class="small mb-0">Restaurante: ${carrito.restaurante.nombre}</p>
                                                        </div>
                                                    </div>
                                                    <div class="d-flex flex-row align-items-center">
                                                        <div style="width: 50px;">
                                                            <h5 class="fw-normal mb-0">${carrito.cantVentas}</h5>
                                                        </div>
                                                        <div style="width: 80px;">
                                                            <h5 class="mb-0">${carrito.precio}</h5>
                                                        </div>
                                                        <a href="#!" style="color: #cecece;"><i class="fas fa-trash-alt"></i></a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>



                            </div>
                            <div class="col-lg-5">

                                <div class="card bg-primary text-white rounded-3 container-detail">
                                    <div class="card-body">
                                        <div class="d-flex justify-content-between align-items-center mb-4">
                                            <h5 class="mb-0">Detalle de compra</h5>
                                            <img src="https://c.tenor.com/-oXfVfBVTHcAAAAC/nicki-minaj-money.gif"
                                                 class="img-fluid rounded-3" style="width: 45px;" alt="Avatar">
                                        </div>



                                        <form class="mt-4">
                                            <div class="form-outline form-white">
                                                <input type="text" id="typeName" class="form-control form-control-lg" siez="17"
                                                       placeholder="Ingrese cupo de descuento" />
                                                <label class="form-label d-none" for="typeName"></label>
                                            </div>



                                        </form>

                                        <hr class="my-4">

                                        <div class="d-flex justify-content-between">
                                            <p class="mb-2">Subtotal</p>
                                            <p class="mb-2">$4798.00</p>
                                        </div>

                                        <div class="d-flex justify-content-between">
                                            <p class="mb-2">Desuento</p>
                                            <p class="mb-2">$20.00</p>
                                        </div>

                                        <div class="d-flex justify-content-between mb-4">
                                            <p class="mb-2">Total(Incl. taxes)</p>
                                            <p class="mb-2">$4818.00</p>
                                        </div>

                                        <button type="button" class="btn btn-info btn-block btn-lg">
                                            <div class="d-flex justify-content-between">
                                                <span>Pagar</span>
                                            </div>
                                        </button>

                                    </div>
                                </div>

                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp"%>