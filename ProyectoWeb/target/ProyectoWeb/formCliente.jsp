<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %> .
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
 <%@include file="header.jsp">


<html>
<body>
<h2>Formulario de Cliente</h2>

<form action="setCliente" method="GET">

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


   <a href="index.jsp">Ir a Inicio</>


  <%@include file="header.jsp">

</body>
</html>