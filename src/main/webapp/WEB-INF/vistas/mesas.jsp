<%@ include file="header.jsp"%>

<style>
    <%@include file="/css/style.css"%>
</style>

<div class="container-general resto-container mt-1">
    <h1 class="title-valorado">${resto.nombre}</h1>

<c:forEach items="${listMesas}" var="mesa">
<%--    <c:choose>--%>
<%--        <c:when test="${listMesa.size()>5}">--%>
<%--            <h5 style="color: #000000;">Esta mesa ofrece el 20% de descuento.</h5>--%>
<%--        </c:when>--%>
<%--        <c:otherwise>--%>
<%--            <p style="color: #000000;">El cupon ${searchTerm} no existe.</p>--%>
<%--        </c:otherwise>--%>
<%--    </c:choose>--%>
    <div class="card" style="width: 18rem;">
        <img src="https://i.gifer.com/7I6v.gif" class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">Numer de mesa: ${mesa.numero}</h5>
            <p class="card-text">Capacidad: ${mesa.capacidad}</p>
            <p class="card-text">Estado: No Reservada</p>
            <a href="#" class="btn btn-primary">Selecccionar</a>
        </div>
    </div>
</c:forEach>
</div>


<%@ include file="footer.jsp"%>
