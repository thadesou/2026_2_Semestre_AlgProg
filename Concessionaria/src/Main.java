public class Main {
    public static void main(String[] args) {

/*
        Veiculo v = new Veiculo();
        v.cadastrar();
        v.modelo = "Fiat " + v.modelo;
        v.ano += 1;
        v.categoria = new Categoria("SUV");
        v.imprimir();
 */
        System.out.println("Preencha os dados do seu carro");
        Carro c1 = new Carro();
        c1.cadastrar();
//        c1.categoria = new Categoria("SUV");
        c1.imprimir();

        System.out.println("\n\n-----------------\n\nAgora preencha os dados da sua moto");
        Categoria cat01 = new Categoria("Esportiva");
        Moto m1 = new Moto();
        m1.cadastrar();
        m1.imprimir();


    }
}