package application;

import db.DB;
import db.DbException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

  public static void main(String[] args) {
    Connection conn = null;
    Statement st = null;
    try {
      conn = DB.getConnection();
      conn.setAutoCommit(false);
      st = conn.createStatement();
      int linha1 = st.executeUpdate(
        "UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1" //todo vendedor do depatamento 1 vai receber 2090
      );

      /* forçando um erro de comunicação no meio da transação
      int x = 1;
      if (x < 2) {
        throw new SQLException("Fake error");
      } 
      */

      int linha2 = st.executeUpdate(
        "UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2" //todo vendedor do depatamento 2 vai receber 3090
      );

      conn.commit();
      System.out.println("Linha 1: " + linha1);
      System.out.println("Linha 2: " + linha2);
    } catch (SQLException e) {
      try {
        conn.rollback();
        throw new DbException("Transacao nao concluida: " + e.getMessage());
      } catch (SQLException e1) {
        throw new DbException(
          "Transacao nao retornou o estado do banco: " + e.getMessage()
        );
      }
    } finally {
      DB.fecharConsulta(st);
      DB.closeConnection();
    }
  }
}
