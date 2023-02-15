package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Account account;

        System.out.print("Digite o numero da conta: ");
        int number = sc.nextInt();

        System.out.print("Digite o nome do titular: ");

        sc.nextLine();//criado apenas para consumir a linha extra que vai para o nextLine

        String holder = sc.nextLine();
        System.out.print("A conta vai ter deposito inicial (s/n) ? ");

        char response = sc.next().charAt(0);
        //if retrata uma sobrecarrga de contrutores na pratica
        if(response == 's'){
            System.out.println("Digitei o valor do deposito inicial: ");
            double initialDeposit = sc.nextDouble();
            account = new Account(number, holder, initialDeposit);
        }else{
            account = new Account(number, holder);
        }

        System.out.println();
        
        System.out.println("Dados da conta");
        System.out.println(account);

        System.out.println();//pular uma linha

        System.out.println("Digite o valor para deposito: ");
        double depositValue = sc.nextDouble();
        account.deposit(depositValue);
        System.out.println("Atualizacao da conta");
        System.out.println(account);

        System.out.println();//pular uma linha

        System.out.println("Digite o valor para saque: ");
        double saqueValue = sc.nextDouble();
        account.withdraw(saqueValue);
        System.out.println("Atualizacao da conta");
        System.out.println(account);

        sc.close();
    }
}
