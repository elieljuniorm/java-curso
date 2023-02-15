package entities;

public class Account {

  private int number;
  private String holder;
  private double balance;

  public int getNumber() { //numero da conta so pode ser lido
    return number;
  }

  public String getHolder() { //leitura de nome
    return holder;
  }

  public void setHolder(String holder) { //modificação de nome
    this.holder = holder;
  }

  public double getBalance() { //so pode ser alterado por meio de saque e deposito dentro da classe
    return balance;
  }

  public Account(int number, String holder) { //contrutor
    this.number = number;
    this.holder = holder;
  }

  public Account(int number, String holder, double initialDeposit) { //construtor
    this.number = number;
    this.holder = holder;
    deposit(initialDeposit);
  }

  public void deposit(double amount){ //função para deposito(esta emcapsulada, se for necessaria em outros lugares deve ser usada a função que contem a regra)
    balance += amount;
  }

  public void withdraw(double amount){ //função para saque com taxa de 5 por saque
    balance -= amount + 5.0;
  }

  public String toString(){
    return "Conta: "
    + number
    + ", Titular: "
    + holder
    + ", saldo da conta: R$ "
    + String.format("%.2f", balance); //formata a resposta com ponto flutuante vinda da variavel
  }
}
