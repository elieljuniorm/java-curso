public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Hello, World!");

        double b, B, h, area; // declaração de tipo
        
        //declaração de valores das variaveis abaixo
        b = 6.0;
        B = 8.0;
        h = 5.0;

        //declaração de logica da variavel
        area = (b + B) / 2.0 * h;

        System.out.println(area); //print do resultado da var area

        int e, d;
        double result;

        e = 5;
        d = 2;

        result = (double) e / d; //neste caso o double precisa vir entre parenteses para o resultado ser double, sem ele o resultado é int

        System.out.println(result);

    }
}
