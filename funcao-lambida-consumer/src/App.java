import entities.Product;
import java.util.ArrayList;
import java.util.List;
import util.PriceUpdate;

public class App {

  public static void main(String[] args) {
    List<Product> list = new ArrayList<>(); //instanciando uma lista de produtos com o construtor product

    list.add(new Product("Tv", 900.00)); //passando as variaveis espradas no contrutor
    list.add(new Product("Mouse", 50.00));
    list.add(new Product("Tablet", 350.50));
    list.add(new Product("HD Case", 80.90));

    list.forEach(new PriceUpdate()); //executa a atualização dos precos da lista, nao pode imprimir direto pelo fato da função so retornar um valor

    list.forEach(System.out::println); //reference methods para o println e mostra na tela o resultado da atualização da lista
  }
}
