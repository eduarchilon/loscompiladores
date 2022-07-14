<%@ include file="header.jsp"%>


<style>
    <%@include file="/css/style.css"%>
</style>
<div class="container-general resto-container mt-1">
    <h3 class="title-valorado">Mis reservas</h3>
    <c:forEach items="${reservas}" var="reserva">
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">Reserva: N ${reserva.id}</h5>
                <p class="card-text">Mesa: ${reserva.mesa.id} - ${reserva.mesa.restaurante.nombre}</p>
                <p class="card-text">Fecha: ${reserva.fecha.time} </p>
                    <%--                <a href="#" class="btn btn-danger">Eliminar</a>--%>
                <form action="/proyecto_limpio_spring_war_exploded/misReservas/${reserva.id}/${clienteId}" method="post">
                    <button class="btn btn-danger" type="submit"  style="color: #cecece;">Eliminar</button>
                </form>
            </div>
        </div>
    </c:forEach>
</div>
<%@ include file="footer.jsp"%>