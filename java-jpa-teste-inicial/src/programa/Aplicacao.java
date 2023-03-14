package programa;

import dominio.Pessoa;

public class Aplicacao {

  public static void main(String[] args) {
    Pessoa p1 = new Pessoa(1, "Joaquina", "joaquina@mgail.com");
    Pessoa p2 = new Pessoa(2, "Maria", "maira@mgail.com");
    Pessoa p3 = new Pessoa(3, "Joao", "joao@mgail.com");
    System.out.println(p1);
    System.out.println(p2);
    System.out.println(p3);
  }
}
