<%@ include file="header.jsp"%>

<style>
    <%@include file="/css/style.css"%>
</style>

<h1 class="title-valorado">${resto.nombre}</h1>
<div class="resto-container">
<c:forEach items="${listMesas}" var="mesa">
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
