package org.ies63prog.dao;

import org.ies63prog.entities.Seguro;
import org.ies63prog.interfaces.AdmConexion;
import org.ies63prog.interfaces.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class SeguroImpl implements DAO<Seguro,Integer>, AdmConexion {

  private static final String SQL_INSERT =
      "INSERT INTO seguro (idSeguro, tipo, costoMensual, compania)" +
          "VALUES (?  ?  ?  ?)";

  private static final String SQL_UPDATE = "UPDATE seguro SET " +
      "idSeguro = ? , tipo = ?, costoMensual = ?, compania = ? " +
      " WHERE idSeguro = ? ";

  private static final String SQL_DELETE = "DELETE  FROM seguro WHERE idSeguro = ?";
  private static final String SQL_GETALL = " SELECT * FROM seguro ORDER BY idSeguro";
  private static final String SQL_GETBYID = "SELECT * FROM seguro WHERE idSeguro = ?";

  @Override
  public List<Seguro> getAll() {
    List<Seguro> lista = new ArrayList<>();
    return lista;
  }

  @Override
  public void insert(Seguro objeto) {
    Connection conn = obtenerConexion();

    PreparedStatement st = null;
    try {
      st = conn.prepareStatement(SQL_INSERT);
      st.execute();
      st.close();
      conn.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void update(Seguro objeto){
    Seguro seguro = new Seguro();
    Connection conn = obtenerConexion();
    if (this.existsById(objeto.getIdSeguro())){
      String sql = "UPDATE seguro SET " +
          "idSeguro = '" + seguro.getIdSeguro() + "', " +
          "tipo = '" + seguro.getTipo()+ "', " +
          "costoMensual = '" + seguro.getCostoMensual() + "', " +
          "compania = '" + seguro.getCompania();
      Statement st = null;
      try {
        st = conn.createStatement();
        st.execute(sql);

        // cierro
        st.close();
        conn.close();
      } catch (SQLException e) {
        System.out.println("Error al crear el statement");
        throw new RuntimeException(e);
      }
    }

    }

  @Override
  public void delete(Integer idSeguro) {
    Connection conn = obtenerConexion();
    PreparedStatement pst=null;


    // 3 crear instruccion
    try {
      pst = conn.prepareStatement(SeguroImpl.SQL_DELETE);
      pst.setInt(1,idSeguro);

      // 4 ejecutar instruccion
      pst.execute();
      // 5 cerrar conexion
      pst.close();
      conn.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }


  @Override
  public Seguro getById(Integer id) {
    Connection conn = obtenerConexion();
    String sql = "SELECT * FROM seguro WHERE idSeguro = " + id;
    Statement st = null;
    ResultSet rs = null;
    Seguro seguro = new Seguro();

    try {
      st = conn.createStatement();
      rs = st.executeQuery(sql);
      if (rs.next()) {
        seguro.setIdSeguro(rs.getInt("idSeguro"));
        seguro.setTipo(rs.getString("tipo"));
        seguro.setCostoMensual(rs.getInt("costoMensual"));
        seguro.setCompania(rs.getString("compania"));
      }
      rs.close();
      st.close();
      conn.close();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return seguro;
  }

  @Override
  public boolean existsById(Integer id) {
    //Connection conn = AdministradorDeConexion.obtenerConexion();
    String sql = "SELECT * FROM seguro WHERE idSeguro = " + id;
    Statement st = null;
    ResultSet rs = null;
    boolean existe = false;

    try{
     // st = conn.createStatement();
      rs = st.executeQuery(sql);
      if(rs.next()){
        existe = true;
      }
      rs.close();
      st.close();
      //conn.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return existe;
  }


}