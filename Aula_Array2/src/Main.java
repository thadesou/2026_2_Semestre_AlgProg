import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Aula sobre Array - Vetor");
//        String lista[] = {"Adalto" , "Flavio" , "João"};
        String nomes[] = new String[3];

        for (int i = 0; i < 3; i++) {

            System.out.print("Digite o " + (i + 1) + "º nome: ");
            nomes[i] = ler.next();
        }
        System.out.println("Lista de convidados: ");
        for (int i = 0; i < 3; i++) {
            System.out.println( nomes[i] );
        }
    }
}