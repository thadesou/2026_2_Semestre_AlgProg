import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Aula sobre Array - Vetor");
        int tam = 5;
        int soma = 0, min = 0, max = 0;
        double media;

        int vetNumeros[] = new int[tam];

        for (int i = 0; i < 3; i++) {

            System.out.print("Digite o " + (i + 1) + "º valor: ");
            vetNumeros[i] = ler.nextInt();
            soma += vetNumeros[i];
            if( i == 0 ){
                min = vetNumeros[i];
                max = vetNumeros[i];
                //min = max = vetNumeros[i};
            }
            else {
                if(vetNumeros[i] < min)
                    min = vetNumeros[i];

                if(vetNumeros[i] > max)
                    max = vetNumeros[i];
            }
        }
        media = soma / tam;
        System.out.println("Mínimo: " + min);
        System.out.println("Máximo: " + max);
        System.out.println("Soma: " + soma);
        System.out.println("Média: " + min);
    }
}
