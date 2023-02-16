package entities;

public class Employee {

  private Integer id;
  private String name;
  private Double salary;

  public Employee() {} //contrutor generico

  public Employee(Integer id, String name, Double salary) { //construtor variaveis gerais
    this.id = id;
    this.name = name;
    this.salary = salary;
  }

  //Get e Set de todos os parametros

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }
  
  //final do Get e Set de todos os parametros

  public void increaseSalary(double percentage) { //função para aumento de salario
    salary += salary * percentage / 100.0;
  }

  public String toString() {
    return id + ", " + name + ", " + String.format("%.2f", salary); //formatação da resposta do valor do salario reajustado
  }
}
