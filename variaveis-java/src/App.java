import pacote.Dog;

public class App {

  public static void main(String[] args) throws Exception {
    System.out.println("meu primeiro código ");

    Dog d1 = new Dog();
    d1.hello(); //chama a função statica da class

    String texto = "print não possui quebra de linha automatica";

    System.out.print(texto);

    String sobreTexto =
      "   println possui quebra de linha automatica por padrão";

    System.out.println(sobreTexto);

    String aindaSobreTexto =
      "printf possibilita usar um argumento para formatar o numero ou pular linha, mas precisa do arugumento que possibilita o uso da variavel";
      
    System.out.printf("%s aqui vai a qubra %n", aindaSobreTexto);

    String name = "Maria";
    double money = 500.50;
    int idade = 23;

    // %f = ponto flutuante  |  %.2f ou %.4f = ponto flutuante com duas ou quatro casas decimais respectivamente
    // %d = inteiro
    // %s = texto
    // %n = qubra de linha

    System.out.printf(
      "%s tem %d anos e ganha R$ %.2f reais %n",
      name,
      idade,
      money
    ); //tem que seguir a mesma ordem do marcador para funcionar
  }
}
