package application;

import db.DB;
import java.sql.Connection;

public class Program {

  public static void main(String[] args) {
    Connection conn = DB.getConnection(); //abre a conexão
    DB.closeConnection(); //fecha a conexão
    //caso tenha algum dado errado na db.properties a conexão dará errada, gera um erro no terminal
  }
}
