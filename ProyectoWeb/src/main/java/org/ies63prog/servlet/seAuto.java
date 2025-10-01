package org.ies63prog.servlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ies63prog.dao.AutoImpl;
import org.ies63prog.entities.Auto;

import java.io.IOException;
import java.util.Date;

public class seAuto extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        req.setAttribute("Mensaje","Hola desde el Servlet ProgI IES63!");
        req.setAttribute("Fecha", new Date());

        String operacion="nuevo";
        String patente="Patente";
        String color="Color";
        String anio= "Anio";
        String kilometraje="Kilometraje";
        Marca marca="Marca";
        String modelo="Modelo";
        Cliente cliente="Cliente";
        Seguro seguro="Seguro";

        patente=req.getParameter("txtPatente");
        color=req.getParameter("txtColor");
        anio=req.getParameter("txtAnio");
        kilometraje=req.getParameter("txtKilometraje")
        marca=req.getParameter("txtMarca");
        modelo=req.getParameter("txtModelo");
        cliente=req.getParameter("txtCliente");
        id=Integer.parseInt(req.getParameter("textId"));

        Auto autoNuevo = new Auto(id, patente, color, anio, kilometraje, marca, modelo, cliente, seguro);
        AutoImpl autoDao = new AutoImpl();
        autoDao.insert(autoNuevo);

        RequestDispatcher rd = req.getRequestDispatcher("/hello.jsp");
        rd.forward(req,response);

    }
}