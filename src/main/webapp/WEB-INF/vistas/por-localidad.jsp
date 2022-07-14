<%@ include file="header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    <%@include file="/css/style.css"%>
</style>


<div class="container-general mt-1">


    <h3 class="title-valorado">Restaurantes</h3>
    <form:form  class="d-flex flex-column mx-auto" style="max-width: 50vw; margin-top:20px;">
        <select class="form-select d-block mx-auto my-2" aria-label="Default select example" id="selectLocalidad">
            <option selected>Seleccionar localidad</option>
            <c:forEach items="${localidades}" var="localidad">
                <option value="${localidad.id}">${localidad.descripcion}</option>
            </c:forEach>
        </select>
    </form:form>
    <form:form class="d-flex flex-column mx-auto" style="max-width: 50vw;margin:10px 0 30px 0;">
        <input type="text" id="localidadId" class="form-control form-control-lg" siez="17"
               placeholder="Ingrese valor"  name="localidadId" style="display: none"/>
        <label class="form-label d-none" for="localidadId" style="display: none"></label>
        <a id="restaurantesLocalidad" class="btn btn-primary" style="width: fit-content;">
            <span>Buscar</span>
        </a>
    </form:form>
    <div class="resto-container mt-1">
        <c:forEach items="${restaurantes}" var="restaurante">
            <div class="card" style="width: 18rem;">
                <img src="https://i.gifer.com/origin/38/38677779204538773550573e0738236e.gif" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">${restaurante.nombre}</h5>
                    <p class="card-text">Tenemos los mejores platos de la zona a un solo click de ditancia.</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Dirección: ${restaurante.direccion}</li>
                    <li class="list-group-item">Telefono: ${restaurante.telefono}</li>
                    <li class="list-group-item">Calificacion: ${restaurante.calificacion}✪</li>
                </ul>
                <div class="card-body">
                    <a href="/proyecto_limpio_spring_war_exploded/platos-del-restaurante/${restaurante.id}" class="card-link">Ver platos</a>
                    <a href="/proyecto_limpio_spring_war_exploded/${restaurante.id}/mesas" class="card-link">Reservar mesas</a>
                </div>
            </div>

        </c:forEach>
    </div>

</div>

<script>
    console.log("Probando");
    document.getElementById("selectLocalidad").addEventListener("change", myFunction);
    function myFunction(e) {
        e.preventDefault();
        let valueSelect = document.getElementById("selectLocalidad").value;
        console.log(valueSelect);
        document.getElementById("localidadId").value = valueSelect;
        let link = "/proyecto_limpio_spring_war_exploded/restaurantes/" + valueSelect + ""
        document.getElementById('restaurantesLocalidad').setAttribute("href", link);
        let a = document.getElementById('restaurantesLocalidad').href;
        console.log(a)
    }
</script>


<%@ include file="footer.jsp"%>
