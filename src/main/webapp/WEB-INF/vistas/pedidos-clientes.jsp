<%--
  Created by IntelliJ IDEA.
  User: Eduar
  Date: 19/6/2022
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>${pedidoBuscado.cliente.nombre}</h3>
<h3>${pedidoBuscado.id}</h3>


  <c:forEach items="${listaPlatos}" var="lista">

    <article class="container jumbotron">}
        <p>${lista.descripcion}</p>
        <p>--------</p>
    </article>

</c:forEach>


</body>
</html>