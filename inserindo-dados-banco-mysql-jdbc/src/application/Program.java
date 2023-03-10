package application;

import db.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {

  public static void main(String[] args) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //mascara para uso de datas

    Connection conn = null;

    PreparedStatement st = null;

    try {
      conn = DB.getConnection();
      st =
        conn.prepareStatement(
          "INSERT INTO seller " +
          "(Name, Email, BirthDate, BaseSalary, DepartmentId)" +
          "VALUES " +
          "(?, ?, ?, ?, ?)"
        );

      st.setString(1, "Eliel Maia");
      st.setString(2, "elieljuniorm@gmail.com");
      st.setDate(3, new java.sql.Date(sdf.parse("18/08/1994").getTime())); //forma de intanciar datas no sql usando o jdbc
      st.setDouble(4, 2505.58);
      st.setInt(5, 4);

      int linhaModificadas = st.executeUpdate();
      System.out.println(
        "Pronto! Numero de linhas modificadas: " + linhaModificadas
      );
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    } finally {
      DB.fecharConsulta(st);
      DB.closeConnection(); //conexão sempre fecha por ultimo
    }
  }
}
