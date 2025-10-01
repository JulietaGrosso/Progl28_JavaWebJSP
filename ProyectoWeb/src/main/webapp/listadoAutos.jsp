<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %> .
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
 <%@include file="header.jsp">
  <%@ page import="org.ies63.progl.dao.AutoImpl">
  <%@ page import="org.ies63.progl.entities.Auto">

  <%@ page import="java.util.ArrayList;">
  <%@ page import="java.util.List;">


<%!
    AutoImpl autoDao = new AutoImpl();
    Auto auto = new Auto();
    List<Auto>listaAutos= autoDao.getAll();
 %>

    <h2>Listado de Autos:</h2>
      <table>
            <thead>
                  <tr>
                    <th>ID</th>
                    <th>Patente</th>
                    <th>Color</th>
                    <th>Anio</th>
                    <th>Kilometraje</th>
                    <th>Marca</th>
                    <th>Modelo</th>
                    <th>Cliente</th>
                    <th>Seguro</th>
                  </tr>

            </thead>
      <tbody>
            <tr>

           <%forEach(Auto auto : listaAutos) { %>
             <! --

           <c:forEach items="${listaAutos}" var="a">
              <tr>
                 <td><%=a.getId() %> </td>
                 <td><%=a.getPatente() %> </td>
                 <td><%=a.getColor() %> </td>
                 <td><%=a.getAnio() %> </td>
                 <td><%=a.getKilometraje() %> </td>
                 <td><%=a.getMarca() %> </td>
                 <td><%=a.getModelo() %> </td>
                 <td><%=a.getCliente() %> </td>
                 <td><%=a.getSeguro() %> </td>

          <% }  %>
           //</c:forEach>

             </tr>

      </tbody>
 </table>