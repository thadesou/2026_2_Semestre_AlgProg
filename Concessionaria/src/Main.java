public class Main {
    public static void main(String[] args) {


        Veiculo v = new Veiculo();
        v.cadastrar();
        v.modelo = "Fiat " + v.modelo;
        v.ano += 1;
        v.categoria = new Categoria("SUV");
        v.imprimir();

    }
}