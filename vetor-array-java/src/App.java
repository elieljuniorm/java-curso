import java.util.Locale;
import java.util.Scanner;

public class App {

  public static void main(String[] args) throws Exception {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    double[] vect = new double[n]; //cria um array inicia ele e cria as quantidade de posição n

    for (int i = 0; i < n; i++) { //i seria o indice do array, vect recebe em cada indice o valor digitado no sc.nextDoule
      vect[i] = sc.nextDouble();
    }

    double sum = 0.0;

    for (int i = 0; i < n; i++) { //faz a soma dos valores do array
      sum += vect[i];
    }

    double media = sum / n; //calcula a média dos valores digitados

    System.out.println("A media das medias e: " + media);

    sc.close();
  }
}
