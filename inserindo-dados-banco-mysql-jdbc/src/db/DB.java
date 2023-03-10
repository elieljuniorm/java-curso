package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

  private static Connection conn = null; //variavel que recebe os dados da conexão, inicia com valor null pra não ficar sem valor

  public static Connection getConnection() { //abre a conexão com o banco
    if (conn == null) {
      try {
        Properties props = loadProperties();
        String url = props.getProperty("dburl");
        conn = DriverManager.getConnection(url, props);
      } catch (SQLException e) {
        throw new DbException(e.getMessage()); //excessão personalizada pra evitar ficar colocando try catch no programa todo
      }
    }
    return conn;
  }

  public static void closeConnection() { //fecha a conexão
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        throw new DbException(e.getMessage());
      }
    }
  }

  private static Properties loadProperties() { //faz a leitra dos dados do arquivo db.properties e trata o erro se tiver vazio
    try (FileInputStream fs = new FileInputStream("db.properties")) {
      Properties props = new Properties();
      props.load(fs);
      return props;
    } catch (IOException e) {
      throw new DbException(e.getMessage());
    }
  }

  public static void fecharConsulta(Statement st) {
    if (st != null) {
      try {
        st.close();
      } catch (SQLException e) {
        throw new DbException(e.getMessage());
      }
    }
  }

  public static void fecharResultado(ResultSet rs) {
    if (rs != null) {
      try {
        rs.close();
      } catch (SQLException e) {
        throw new DbException(e.getMessage());
      }
    }
  }
}
