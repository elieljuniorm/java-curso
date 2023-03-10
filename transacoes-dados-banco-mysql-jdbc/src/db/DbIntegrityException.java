package db;

public class DbIntegrityException extends RuntimeException {

  public DbIntegrityException(String msg) {//excessão personalizada de integridade referencial
    super(msg);
  }
}
