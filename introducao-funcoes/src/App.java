import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Digite 3 números e verificaremos qual é o maior:"); // Texto de apresentação

    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    int maiorValor = max(a, b, c);

    showResult(maiorValor);

    sc.close();
  }

  public static int max(int x, int y, int z) { // Função que verifica e retorna o maior valor
    int aux;
    if (x > y && x > z) {
      aux = x;
    } else if (y > z) {
      aux = y;
    } else {
      aux = z;
    }
    return aux;
  }

  public static void showResult(int value) { //Retorna o texto e o valor da função anterior
    System.out.println("Maior valor digitado = " + value);
  }
}
