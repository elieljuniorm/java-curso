package application;

import db.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program {

  public static void main(String[] args) {
    Connection conn = null;
    PreparedStatement st = null;
    try {
      conn = DB.getConnection();
      st =
        conn.prepareStatement(
          "UPDATE seller " +
          "SET BaseSalary = BaseSalary + ? " +
          "WHERE " +
          "(DepartmentId = ?)"
        );

      st.setDouble(1, 200); //aumenta em 200 o salario
      st.setInt(2, 2); //de todos que estiverem no departamento 2

      int linhasAfetadas = st.executeUpdate();

      System.out.println(
        "Pronto! Numero de linhas afetadas: " + linhasAfetadas
      );
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DB.fecharConsulta(st);
      DB.closeConnection();
    }
  }
}
