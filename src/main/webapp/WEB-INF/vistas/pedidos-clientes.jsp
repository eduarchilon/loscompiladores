<%@ include file="header.jsp"%>

<style>
    <%@include file="/css/style.css"%>
</style>

<h3 class="title-valorado">${pedidoBuscado.cliente.nombre} ${pedidoBuscado.cliente.apellido}</h3>
<div class="resto-container">
  <c:forEach items="${listaPlatos}" var="lista">
      <div class="card" style="width: 18rem;">
          <img src="https://i.blogs.es/1d2f94/1366_2000-15-/450_1000.webp" class="card-img-top" alt="...">
          <div class="card-body">
              <h5 class="card-title">${lista.nombre}</h5>
              <p class="card-text">${lista.descripcion}</p>
              <p class="card-text">Precio: $${lista.precio}</p>
          </div>
      </div>
</c:forEach>
</div>
<%@ include file="footer.jsp"%>
