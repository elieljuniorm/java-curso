import entities.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import util.UppercaseName;

public class App {

  public static void main(String[] args) {
    List<Product> list = new ArrayList<>(); //instanciando uma lista de produtos com o construtor product

    list.add(new Product("Tv", 900.00)); //passando as variaveis espradas no contrutor
    list.add(new Product("Mouse", 50.00));
    list.add(new Product("Tablet", 350.50));
    list.add(new Product("HD Case", 80.90));

    List<String> nomesMaiusculos = list
      .stream()
      .map(new UppercaseName())
      .collect(Collectors.toList());
    /* list.stream é usado para conseguirmos usar a função map que retorna uma nova lista com o parametro passado UppercaseName() que transforma tudo em mausculo, essa lista vai retonar em forma de map e precisa ser convertida em lista novamente, por isso usamos a função collect(Collectors.toList()) que transforma o retorno da função map em lista novamente */

    nomesMaiusculos.forEach(System.out::println);
  }
}
