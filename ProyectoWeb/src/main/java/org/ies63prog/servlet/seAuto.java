package org.ies63prog.servlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ies63prog.dao.AutoImpl;
import org.ies63prog.dao.ClienteImpl;
import org.ies63prog.entities.Auto;
import org.ies63prog.entities.Cliente;
import org.ies63prog.entities.Marca;
import org.ies63prog.entities.Seguro;

import java.io.IOException;
import java.util.Date;

public class seAuto extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        req.setAttribute("Mensaje","Hola desde el Servlet ProgI IES63!");
        req.setAttribute("Fecha", new Date());

        String operacion="nuevo";
        String patente="";
        String color="";
        int anio;
        int kilometraje;
        Marca marca;
        String modelo="";
        Cliente cliente;
        Seguro seguro;
        int id = -1;



        operacion = req.getParameter("operacion");

        if (operacion.equals("editar") || operacion.equals("nuevo")) {
            patente=req.getParameter("txtPatente");
            color=req.getParameter("txtColor");
            anio= Integer.parseInt(req.getParameter("txtAnio"));
            kilometraje=Integer.parseInt(req.getParameter("txtKilometraje"));
            marca=Marca.valueOf((req.getParameter("txtMarca")));
            modelo=req.getParameter("txtModelo");
            cliente=Cliente.valueOf((req.getParameter("txtCliente"));
            seguro=String.valueOf((req.getParameter("txtSeguro")));
            id=Integer.parseInt(req.getParameter("textId"));
        } else
            id = Integer.parseInt(req.getParameter("id"));

        AutoImpl autoDao = new AutoImpl();

        if (operacion.equals("nuevo")) {// es nuevo
            Auto autoNuevo = new Auto(patente,color,anio,kilometraje,marca,modelo,cliente,seguro);
                autoDao.insert(autoNuevo);
        }
        if (operacion.equals("editar")) {// es editar
            Auto autoEditar = autoDao.getById(id);
            autoEditar.setPatente(patente);
            autoDao.update(autoEditar);
        }
        if (operacion.equals( "eliminar")) {
            autoDao.delete(id);
        }

        RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
        rd.forward(req, response);
    }


}