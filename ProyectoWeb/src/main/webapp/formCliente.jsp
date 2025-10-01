<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %> .
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
 <%@include file="header.jsp">


<jsp:useBean id="cliente" class="org.progI.entities.Cliente" scope="request" />
<jsp:useBean id="clienteDao" class="org.progI.dao.ClienteImpl" scope="page" />

<c:if test="${param.operacion == 'editar'}">
    <c:set var="idCliente" value="${Integer.parseInt(param.id)}" />
    <c:set var="clienteEditar" value="${clienteDao.getById(idCliente)}" />
</c:if>

<c:choose>
    <c:when test="${param.operacion == 'editar'}" > Editar Cliente </c:when>
    <c:when test="${param.operacion == 'eliminar'}" > Eliminar Cliente </c:when>
    <c:otherwise> Nuevo Cliente </c:otherwise>
</c:choose>

<html>
<body>
    <h2>Formulario de Cliente</h2>

    <form action="seCliente" method="GET">

            <imput type="hidden" name="txtId" id="txtId" value="-1"/>
            <imput type="hidden" name="Operacion" id="operacion" value="nuevo"/>


        <label for="txtNombre">Nombre</label>
            <imput type="text" name="txtNombre" id="txtNombre" placeholder="Nombre"</required>
        <br>
        <label for="txtApellido">Apellido</label>
            <imput type="text" name="txtApellido" id="txtApellido" placeholder="Apellido"</required>
        <br>
        <label for="txtTelefono">Telefono</label>
            <imput type="text" name="txtTelefono" id="txtTelefono" placeholder="Telefono"</required>
        <br>

            <imput type="submit" value="Enviar"/>

    </form>


    <a href="index.jsp">Ir al Inicio</a>


    <%@ include file="footer.jsp" %>


</body>
</html>