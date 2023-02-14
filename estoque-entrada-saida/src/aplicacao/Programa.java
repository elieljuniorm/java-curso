package aplicacao;

import entidade.Produto;
import java.util.Locale;
import java.util.Scanner;

public class Programa {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.println("Entre product data: ");
    
    System.out.print("Name: ");
    String name = sc.nextLine(); //variavel temporaria pra criação de dados

    System.out.print("Price: ");
    double price = sc.nextDouble(); //variavel temporaria pra criação de dados

    System.out.print("Quantity in stock: ");
    int quantity = sc.nextInt(); //variavel temporaria pra criação de dados

    Produto product = new Produto(name, price, quantity); //utilização do contrutor após a entrada de dados pelo programador, evita inicialização sem dados

    System.out.println();//pulando uma linha apenas
    System.out.println("Product data: " + product);

    System.out.println();
    System.out.print("Entre com o numero de produtos para serem adicionados no estoque: ");
    quantity = sc.nextInt();
    product.addProducts(quantity);

    System.out.println();//pulando uma linha apenas
    System.out.println("Updated data: " + product);

    System.out.println();
    System.out.print("Entre com o numero de produtos para serem REMOVIDOS do estoque: ");
    quantity = sc.nextInt();
    product.removeProducts(quantity);

    System.out.println();//pulando uma linha apenas
    System.out.println("Updated data: " + product);

    sc.close();
  }
}
