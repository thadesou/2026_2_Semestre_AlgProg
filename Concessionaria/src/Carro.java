import java.util.Scanner;

public class Carro extends Veiculo{
    public int qtdPortas;
    public int volPortaMalas;

    @Override
    public void cadastrar() {
        super.cadastrar();
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite a quantidade de portas: ");
        this.qtdPortas = ler.nextInt();
        System.out.print("Informe o volume do Porta-malas: ");
        this.volPortaMalas = ler.nextInt();

    }

    @Override
    public void imprimir() {
        System.out.println("Carro: ");
        super.imprimir();
        System.out.println("Quantidade de Portas: " + this.qtdPortas);
        System.out.println("Volume do Porta-malas: " + this.volPortaMalas + "L");
    }
}
