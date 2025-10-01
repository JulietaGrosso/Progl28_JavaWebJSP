<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %> .
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<jsp:useBean id="auto" class="org.progI.entities.Auto" scope="request" />
<jsp:useBean id="AutoDao" class="org.progI.dao.AutoImpl" scope="page" />

<c:if test="${param.operacion == 'editar'}">
    <c:set var="idAuto" value="${Integer.parseInt(param.id)}" />
    <c:set var="autoEditar" value="${autoDao.getById(idAuto)}" />
</c:if>

<c:choose>
    <c:when test="${param.operacion == 'editar'}" > Editar Auto </c:when>
    <c:when test="${param.operacion == 'eliminar'}" > Eliminar Auto </c:when>
    <c:otherwise> Nuevo Auto </c:otherwise>
</c:choose>


<html>
<body>
    <h2>Hello World!</h2>
    <a href="hello">ir al HelloServlet</a>
    <h2> Formulario de Auto<h2>
    <form action= Formulario de Auto<h2>
    <h2>Formulario de Auto</h2>

    <form action="setAuto" method="GET">

        <imput type="hidden" name="txtId" id="txtId" value="-1"/>
        <imput type="hidden" name="Operacion" id="operacion" value="nuevo"/>


        <label for="txtPatente">Patente</label>
            <imput type="text" name="txtPatente" id="txtPatente" placeholder="Patente"
            //value="${not empty autoEditar.patente ? autoEditar.patente: ''}"
            </required>
        <br>

        <label for="txtColor">Color</label>
            <imput type="text" name="txtColor" id="txtColor" placeholder="Color"</required>
        <br>
        <label for="txtAnio">anio</label>
            <imput type="text" name="txtAnio" id="txtAnio" placeholder="Anio"</required>
        <br>
        <label for="txtkilometraje">kilometraje</label>
            <imput type="text" name="txtkilometraje" id="txtkilometraje" placeholder="kilometraje"</required>
        <br>
        <label for="txtMarca">Marca</label>
            <imput type="text" name="txtMarca" id="txtMarca" placeholder="Marca"</required>
        <br>
        <label for="txtModelo">Modelo</label>
            <imput type="text" name="txtModelo" id="txtModelo" placeholder="Modelo"</required>
        <br>
        <label for="txtCliente">Cliente</label>
            <imput type="text" name="txtCliente" id="txtCliente" placeholder="Cliente"</required>
        <br>
        <label for="txtSeguro">Seguro</label>
            <imput type="text" name="txtSeguro" id="txtSeguro" placeholder="Seguro"</required>
        <br>


            <imput type="submit" value="Enviar"/>
    </form>

       <a href="index.jsp">Ir al Inicio</a>

       <a href="index.jsp">Ir a Inicio</>


      <%@include file="header.jsp">

</body>
</html>
