package org.ies63prog.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ies63prog.dao.ClienteImpl;
import org.ies63prog.entities.Cliente;

import java.io.IOException;
import java.util.Date;

public class seCliente extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

    req.setAttribute("Mensaje","Hola desde el Servlet ProgI IES63!");
    req.setAttribute("Fecha", new Date());
    String operacion="nuevo";
    String nombre="Nombre";
    String apellido="Apellido";
    String telefono="telefono";
    int id=-1;

    nombre=req.getParameter("txtNombre");
    nombre=req.getParameter("txtApellido");
    nombre=req.getParameter("txtTelefono");
    nombre=req.getParameter("operacion");
    id=Integer.parseInt(req.getParameter("textId"));

    Cliente clienteNuevo = new Cliente(id,nombre,apellido,telefono);
    ClienteImpl clienteDao= new ClienteImpl();
    clienteDao.insert(clienteNuevo);

    RequestDispatcher rd = req.getRequestDispatcher("/hello.jsp");
    rd.forward(req,response);

  }

  /* agregar en la bdd
  INSERT INTO cliente (´nombre´, ´apellido´,´dni´, ´correo´, ´localidad´) VALUES
('Abril', 'Gómez', '34214567', 'abg.gomez@example.com', 'Santa Fe'),
('Lucas', 'Pérez', '29876543', 'lucas.perez@example.com', 'Reconquista'),
('Donato', 'Grosso', '33456789', 'donna@example.com', 'Las Toscas'),
('Mateo', 'Grosso', '31234567', 'mateog@example.com', 'San Antonio de Obl.'),
('Luz', 'Gonzalez', '30567891', 'luzcat@example.com', 'Las Toscas');*/

}
