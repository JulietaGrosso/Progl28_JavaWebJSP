package org.ies63prog.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

public class HelloServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

    req.setAttribute("Mensaje","Hola desde el Servlet ProgI IES63!");
    req.setAttribute("Fecha", new Date());
    RequestDispatcher rd = req.getRequestDispatcher("/hello.jsp");
    rd.forward(req,response);

  }



}