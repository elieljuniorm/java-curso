package application;

import entities.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    List<Employee> list = new ArrayList<>();  //declaração de ArrayList

	/* Podemos dizer que ArrayList é uma classe para coleções. Uma classe genérica (generic classes), para ser mais exato. Coleções mesmo, de qualquer tipo de 'coisa' ou dado, não somente de tipos primitivos */

    // PART 1 - LEITURA DE DADOS:

    System.out.print("Quantos funcionarios serao cadastrados? "); //texto de entrada
    int n = sc.nextInt();

    for (int i = 1; i <= n; i++) {
      System.out.println();
      System.out.println("Funcionario #" + i + ": "); //utiliza o indice da lista para numerar a entrada do funcionario

      System.out.print("Id: ");
      int id = sc.nextInt();
      while (hasId(list, id)) { //validação de funcionario existente
        System.out.print("Id ja utilizado. Tente novamente: ");
        id = sc.nextInt();
      }

      System.out.print("Nome: ");
      sc.nextLine();
      String name = sc.nextLine();
      System.out.print("Salario: ");
      double salary = sc.nextDouble();
      list.add(new Employee(id, name, salary)); //adiciona o nome e o salario digitado na lista, criando um id junto com a entrada do dado
    }

    // PART 2 - ATUALIZAÇÃO DE SALÁRIO DE DETERMINADO FUNCIONÁRIO:

    System.out.println();
    System.out.print("Informe o CPF do funcionario que terá aumento salarial: ");
    int id = sc.nextInt();
    Employee emp = list
      .stream()
      .filter(x -> x.getId() == id)
      .findFirst()
      .orElse(null); //outra forma de filtrar a lista usando lambida para saber se o empregado(employee) existe na hora do aumento do salario
    if (emp == null) {
      System.out.println("Este id nao existe!");
    } else {
      System.out.print("Entre com a porcentagem: ");
      double percentage = sc.nextDouble();
      emp.increaseSalary(percentage); //função que repassa o aumento, trazida da classe
    }

    // PART 3 - LISTAGEM DE FUNCIONÁRIOS:

    System.out.println();
    System.out.println("Lista de funcionarios:");
    for (Employee obj : list) {
      System.out.println(obj); //utiliza o contrutor pra trazer os dados dos funcionarios atualizados
    }

    sc.close();
  }

  public static boolean hasId(List<Employee> list, int id) { //função auxiliar que retorna a posição do funcionario na lista com base no id
    Employee emp = list
      .stream()
      .filter(x -> x.getId() == id)
      .findFirst()
      .orElse(null);
    return emp != null; //retorna apenas funcionarios existentes(valor diferente de null)
  }
}
