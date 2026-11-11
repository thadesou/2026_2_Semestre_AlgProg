public class ColaboradorComissionado extends Colaborador {

    private double valorVendas;
    private double percentualComissao;

    public ColaboradorComissionado(int matricula, String nome,
                                   double valorVendas, double percentualComissao) {
        super(matricula, nome);
        this.valorVendas = valorVendas;
        this.percentualComissao = percentualComissao;
    }

    public double getValorVendas() {
        return valorVendas;
    }

    public void setValorVendas(double valorVendas) {
        if (valorVendas >= 0) {
            this.valorVendas = valorVendas;
        }
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(double percentualComissao) {
        if (percentualComissao >= 0 && percentualComissao <= 100) {
            this.percentualComissao = percentualComissao;
        }
    }

    // comissão = valorVendas × percentualComissao ÷ 100
    public double calcularComissao() {
        return valorVendas * percentualComissao / 100;
    }

    // salário final = salário base + comissão
    @Override
    public double calcularSalarioFinal() {
        return getSalarioBase() + calcularComissao();
    }

    @Override
    public String getTipo() {
        return "Comissionado";
    }

    @Override
    protected void exibirBeneficio() {
        System.out.println("Comissão: " + formatarMoeda(calcularComissao()));
    }
}
