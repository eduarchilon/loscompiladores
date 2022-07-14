<%@ include file="header.jsp"%>


<style>
  <%@include file="/css/style.css"%>
</style>


<div class="container-general resto-container mt-1">
  <h3 class="title-valorado">Nuestros Clientes</h3>
<c:forEach items="${clientes}" var="cliente">
  <div class="card" style="width: 18rem;">
    <img src="https://i.giphy.com/media/JApxkdelkzBIY/giphy.gif" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">${cliente.nombre} ${cliente.apellido}</h5>
      <p class="card-text">Localidad: Buenos Aires</p>
      <a href="ver-pedido-cliente/${cliente.nombre}" class="btn btn-primary">Ver pedidos</a>
      <a href="misReservas?idCiente=${cliente.id}" class="btn btn-primary">Ver reservas</a>
    </div>
  </div>
</c:forEach>
</div>

  <h5 class="title-valorado">${buscado.nombre} ${buscado.apellido}</h5>

<div class="resto-container">
  <c:forEach items="${pedidos}" var="pedido">
  <div class="card" style="width: 18rem;">
    <div class="card-body">
      <h5 class="card-title">Pedido nro: P100${pedido.id}</h5>
      <a href="${pedido.cliente.nombre}/ver-platos-del-pedido/${pedido.id}" class="card-link">Ver detalle</a>
    </div>
  </div>
  </c:forEach>
</div>

<%@ include file="footer.jsp"%>