package application;

import db.DB;
import db.DbIntegrityException;
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
        conn.prepareStatement("DELETE FROM department " + "WHERE " + "Id = ?");
      // WHERE é muito importante, garante que o comando seja somente para a linha escolida, sem ele tudo será apagado, na atualização tambem é necessario

      st.setInt(1, 5); //departamento 5

      int linhasAfetadas = st.executeUpdate();

      System.out.println(
        "Pronto! Numero de linhas afetadas: " + linhasAfetadas
      );
    } catch (SQLException e) {
      throw new DbIntegrityException(e.getMessage());
    } finally {
      DB.fecharConsulta(st);
      DB.closeConnection();
    }
  }
}
