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

  public Account(int number, String holder) {
    this.number = number;
    this.holder = holder;
  }

  public Account(int number, String holder, double balance) {
    this.number = number;
    this.holder = holder;
    this.balance = balance;
  }
}
