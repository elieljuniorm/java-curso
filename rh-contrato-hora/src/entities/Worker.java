package entities;

import entities.enums.WorkerLevel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {

  //variáveis/atributos básicos
  private String name;
  private WorkerLevel level;
  private Double baseSalary;

  //associações
  private Department department; //nome dos funcionarios
  //na composição de contrutor, listas não entram no construtor, somente iniciada com ArrayLista() para ser utilizada
  private List<HourContract> contracts = new ArrayList<>(); //list/array com os contratos de horas de trabalho

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public WorkerLevel getLevel() {
    return level;
  }

  public void setLevel(WorkerLevel level) {
    this.level = level;
  }

  public Double getBaseSalary() {
    return baseSalary;
  }

  public void setBaseSalary(Double baseSalary) {
    this.baseSalary = baseSalary;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public List<HourContract> getContracts() { //list nao tem set para nao ser trocada, ela somente recebe os dados
    return contracts;
  }

  public Worker() {}

  public Worker(
    String name,
    WorkerLevel level,
    Double baseSalary,
    Department department
  ) {
    this.name = name;
    this.level = level;
    this.baseSalary = baseSalary;
    this.department = department;
  }

  public void addContract(HourContract contract) {
    contracts.add(contract);
  }

  public void removeContract(HourContract contract) {
    contracts.remove(contract);
  }

  public Double income(int year, int month) {
    double sum = baseSalary;
    Calendar cal = Calendar.getInstance();
    for (HourContract c : contracts) {
      cal.setTime(c.getDate());
      int c_year = cal.get(Calendar.YEAR);
      int c_month = 1 + cal.get(Calendar.MONTH); //acrescimo de 1 pelo fato do mes do calendar começar com zero
      if (year == c_year && month == c_month) {
        sum += c.totalValue();
      }
    }
    return sum;
  }
}
