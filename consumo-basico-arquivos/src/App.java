import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {

  public static void main(String[] args) throws Exception {
    File file = new File("C:\\Users\\eliel\\Documents\\java-curso\\consumo-basico-arquivos\\in.txt");  //instanciando caminho do arquivo, sempre com barras duplas
    Scanner sc = null;
    try {
      sc = new Scanner(file);
      while (sc.hasNextLine()) {
        System.out.println(sc.nextLine());
      }
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    } finally {
      if (sc != null) {
        sc.close();
      }
    }
  }
}
