<%@ include file="header.jsp"%>


<style>
    <%@include file="/css/style.css"%>
</style>

<h1>Crear Reserva</h1>
<%-- necesito traer los horarios del restaurante y las mesas, y devolverlos al controlador --%>
<form>
    <div class="row">
        <div class="col">
            <input type="datetime-local" class="form-control" placeholder="First name" id="fecha" value="${date}">
        </div>
        <div class="col">
            <input type="text" class="form-control" id="idResto" style="display: none" value="${restaurante.id}">
        </div>
    </div>
    <a class="btn" href="/crear-reserva/" id="buscarMesas" disabled="true">buscar mesas</a>
</form>
<div class="container">
    <c:forEach items="${mesas}" var="mesa">
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">mesa numero ${mesa.numero}</h5>
            <p class="card-text">Capacidad: ${mesa.capacidad}</p>
            <a href="/proyecto_limpio_spring_war_exploded/crear-reserva/red/1/${mesa.id}/${date}" class="btn btn-primary">Reservar</a>
        </div>
    </div>
    </c:forEach>
</div>
<script>
    document.getElementById("fecha").addEventListener("change", myFunction);
    function myFunction(e) {
        e.preventDefault();
        let valueSelected = document.getElementById("fecha").value;
        let valueID = document.getElementById("idResto").value;
        console.log(valueSelected);
        // document.getElementById("localidadId").value = valueSelect;
        let link = "/proyecto_limpio_spring_war_exploded/crear-reserva/"+valueID+"/" + valueSelected + ""
        document.getElementById('buscarMesas').setAttribute("href", link);
        document.getElementById('buscarMesas').setAttribute("disabled", "false");
        let a = document.getElementById('buscarMesas').href;
        console.log(a)
    }
</script>
<%@ include file="footer.jsp"%>
