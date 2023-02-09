import java.util.Locale; //imoortação do metodo para modificar a localidade do numero fracionario
import java.util.Scanner; //importação do metodo para utilização

public class App {

  public static void main(String[] args) {

    Locale.setDefault(Locale.US); //localidade do EUA(Pode ser Brasil tambem), numeros fracionarios separedos com .

    //localidade do por padrão é a localidade do computador, no caso Brasil
    
    Scanner sc = new Scanner(System.in); //metodo para entrada de dados pelo teclado no terminal

    String x;

    x = sc.next(); //função para capturar o que foi digitado e armazenar na variavel

    int y;

    y= sc.nextInt(); //função para inteiros

    double z;

    z = sc.nextDouble();

    char v;

    v = sc.next().charAt(0); //recebe a quantidade de cacarcter informado no charAt()

    System.out.println("Você digitou: " + x + " o número " + y + " e o número " + z + " Uma leta " + v);

    sc.close(); //funçao obrigatoria para fechar o metodo
  }
}