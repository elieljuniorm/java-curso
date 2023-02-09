import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner tx = new Scanner(System.in);

        int x;
        
        String Tx1, Tx2, Tx3;

        x = tx.nextInt();

        tx.nextLine(); // ATENÇÃO
        /* quando for utilizado nextLine com outro tipo de next, ele precisa ter um a mais que o diferente para agrantir a entrada do dados, sem isso ele come um nextLine que seria necessario para a proxima renderização */

        Tx1 = tx.nextLine(); //função para ler a linha inteira
        Tx2 = tx.nextLine();
        Tx3 = tx.nextLine();

        System.out.println("Seus pensamentos digitados: ");
        System.out.println(x);
        System.out.println(Tx1);
        System.out.println(Tx2);
        System.out.println(Tx3);

        tx.close();
    }
}
