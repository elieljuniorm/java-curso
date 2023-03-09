import entities.Product;
import util.ProductPredicate;

import java.util.ArrayList;
import java.util.List;

public class App {

  public static void main(String[] args) {
    List<Product> list = new ArrayList<>(); //instanciando uma lista de produtos com o construtor product

    list.add(new Product("Tv", 900.00)); //passando as variaveis espradas no contrutor
    list.add(new Product("Mouse", 50.00));
    list.add(new Product("Tablet", 350.50));
    list.add(new Product("HD Case", 80.90));

    list.removeIf(new ProductPredicate() /* p -> p.getPrice() >= 100 */); //funçao lambida com tipagem abstraida e usando arrow function para retornar um boolean
    //new ProductPredicate() representa a testagem lambida escrita, mas recebida do predicado da classe

    for(Product p : list){ //para cada produto p na minha lista list faça...
      System.out.println(p);
    }
  }
}
