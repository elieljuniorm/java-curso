package util;

import entities.Product;
import java.util.function.Predicate;

public class ProductPredicate implements Predicate<Product> {

  @Override
  public boolean test(Product p) {
    return p.getPrice() >= 100; //teste que retorna um boolean
  }
}
//representa uma interface funcional, pelo fato de so ter um metodo abstrato para ser implementado