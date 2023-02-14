package entidade;

public class Produto {

  public String name;
  public double price;
  public int quantity; //quantity instancia da classe produto

  public Produto(String name, double price, int quantity) { //construtor criado para evitar inicialização sem dados
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public double totalValueInStock() {
    return price * quantity;
  }

  public void addProducts(int quantity) { //quantity argumento
    this.quantity += quantity;
    //THIS esta referenciando a instacia da minha classe e o outro QUANTITY está referenciando o argumento da função
  }

  public void removeProducts(int quantity) {
    this.quantity -= quantity;
  }

  public String toString() {
    return (
      name +
      ", R$ " +
      String.format("%.2f", price) +
      ", " +
      quantity +
      " units, Total: R$ " +
      String.format("%.2f", totalValueInStock())
    );
  }
}
