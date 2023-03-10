package application;

import db.DB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

  public static void main(String[] args) {
    Connection conn = null; //faz a conexão
    Statement st = null; //prepara e faz consulta no banco
    ResultSet rs = null; //armazena o resultado da consulta

    try {
      conn = DB.getConnection();

      st = conn.createStatement();

      rs = st.executeQuery("select * from department");

      while (rs.next()) {
        System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally { //chama o fechamento das funções do banco evitando problemas de memoria
      DB.fecharConsulta(st); //fechamento tratado na DB.java
      DB.fecharResultado(rs); //fechamento tratado na DB.java
      DB.closeConnection(); //fechamento tratado na DB.java
    }
  }
}
