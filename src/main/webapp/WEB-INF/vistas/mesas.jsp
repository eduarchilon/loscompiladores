<%@ include file="header.jsp"%>

<style>
    <%@include file="/css/style.css"%>
</style>

<h1>${resto.nombre}</H1>
<c:forEach items="${listMesas}" var="mesa">
    <h1>${mesa.numero}</h1>
</c:forEach>


<%@ include file="footer.jsp"%>
