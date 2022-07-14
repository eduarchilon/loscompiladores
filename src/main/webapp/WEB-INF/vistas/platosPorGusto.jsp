<%@ include file="header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    <%@include file="/css/style.css"%>
</style>

<div class="container-general mt-1">


    <h3 class="title-valorado">Todos los platos</h3>
    <form:form class="d-flex flex-column mx-auto" style="max-width: 50vw; margin-top:20px;">
        <select class="form-select d-block mx-auto my-2" aria-label="Default select example" id="selectGusto">
            <option selected>Seleccionar Gusto</option>
            <c:forEach items="${tipoGusto}" var="gusto">
                <option value="${gusto.id}">${gusto.nombre}</option>
            </c:forEach>
        </select>
    </form:form>
    <form:form class="d-flex flex-column mx-auto" style="max-width: 50vw;margin:10px 0 30px 0;">
        <input type="text" id="tipoGustoId" class="form-control form-control-lg" siez="17"
               placeholder="Ingrese valor"  name="tipoGustoId" style="display: none"/>
        <label class="form-label d-none" for="tipoGustoId" style="display: none"></label>
        <a id="tipoGustoPlato" class="btn btn-primary" style="width: fit-content;">
            <span>Buscar</span>
        </a>
    </form:form>
    <div class="resto-container mt-1">
        <c:forEach items="${platos}" var="plato">
            <div class="card" style="width: 18rem;">
                <img src="https://i.blogs.es/1d2f94/1366_2000-15-/450_1000.webp" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">${plato.nombre}</h5>
                    <p class="card-text">${plato.descripcion}</p>
                    <p class="card-text">Precio: $${plato.precio}</p>
                    <form action="/proyecto_limpio_spring_war_exploded/agregar-plato/${plato.id}" method="post">
                        <button type="submit" class="btn btn-primary">Agregar al pedido</button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>

</div>

<script>
    console.log("Probando");
    document.getElementById("selectGusto").addEventListener("change", myFunction);
    function myFunction(e) {
        e.preventDefault();
        let valueSelect = document.getElementById("selectGusto").value;
        console.log(valueSelect);
        document.getElementById("tipoGustoId").value = valueSelect;
        let link = "/proyecto_limpio_spring_war_exploded/ver-platos/" + valueSelect + ""
        document.getElementById('tipoGustoPlato').setAttribute("href", link);
        let a = document.getElementById('tipoGustoPlato').href;
        console.log(a)
    }
</script>
<%@ include file="footer.jsp" %>