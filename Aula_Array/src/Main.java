import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Aula sobre Array - Vetor");
        int vetNumeros[] = new int[3];

        for (int i = 0; i < 3; i++) {

            System.out.print("Digite o " + (i + 1) + "º valor: ");
            vetNumeros[i] = ler.nextInt();
        }
        for (int i = 0; i < 3; i++) {

            System.out.println("O dobro de " + vetNumeros[i] + " é: " + (vetNumeros[i] * 2));

        }
    }
}
