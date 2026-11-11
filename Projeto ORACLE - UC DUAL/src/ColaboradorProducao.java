public class ColaboradorProducao extends Colaborador {

    private int quantidadePecas;
    private double valorPorPeca;

    public ColaboradorProducao(int matricula, String nome,
                               int quantidadePecas, double valorPorPeca) {
        super(matricula, nome);
        this.quantidadePecas = quantidadePecas;
        this.valorPorPeca = valorPorPeca;
    }

    public int getQuantidadePecas() {
        return quantidadePecas;
    }

    public void setQuantidadePecas(int quantidadePecas) {
        if (quantidadePecas >= 0) {
            this.quantidadePecas = quantidadePecas;
        }
    }

    public double getValorPorPeca() {
        return valorPorPeca;
    }

    public void setValorPorPeca(double valorPorPeca) {
        if (valorPorPeca >= 0) {
            this.valorPorPeca = valorPorPeca;
        }
    }

    // produtividade = quantidadePecas × valorPorPeca
    public double calcularProdutividade() {
        return quantidadePecas * valorPorPeca;
    }

    // salário final = salário base + produtividade
    @Override
    public double calcularSalarioFinal() {
        return getSalarioBase() + calcularProdutividade();
    }

    @Override
    public String getTipo() {
        return "Produção";
    }

    @Override
    protected void exibirBeneficio() {
        System.out.println("Produtividade: " + formatarMoeda(calcularProdutividade()));
    }
}
