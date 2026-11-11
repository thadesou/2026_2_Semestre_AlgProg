public class ColaboradorPadrao extends Colaborador {

    public ColaboradorPadrao(int matricula, String nome) {
        super(matricula, nome);
    }

    @Override
    public String getTipo() {
        return "Padrão";
    }

    // Salário final = salário base (comportamento herdado de Colaborador)
    @Override
    public double calcularSalarioFinal() {
        return getSalarioBase();
    }
}
