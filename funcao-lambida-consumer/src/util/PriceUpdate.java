package util;

import entities.Product;
import java.util.function.Consumer;

public class PriceUpdate implements Consumer<Product> {

  @Override
  public void accept(Product p) { //interface consumer somente retorna um valor (void) para ser consumido, no caso em exemplo em valor ajustado de preço recebido do construtor
    p.setPrice(p.getPrice() * 1.1);
  }
}
