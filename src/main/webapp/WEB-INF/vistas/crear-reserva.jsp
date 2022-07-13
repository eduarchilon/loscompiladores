<%@ include file="header.jsp"%>


<style>
    <%@include file="/css/style.css"%>
</style>

<h1>Crear Reserva</h1>
<%-- necesito traer los horarios del restaurante y las mesas, y devolverlos al controlador --%>
<form>
    <div class="row">
        <div class="col">
            <input type="date" class="form-control" placeholder="First name">
        </div>
        <div class="col">
            <input type="text" class="form-control" placeholder="Last name">
        </div>
    </div>
</form>
<%@ include file="footer.jsp"%>
