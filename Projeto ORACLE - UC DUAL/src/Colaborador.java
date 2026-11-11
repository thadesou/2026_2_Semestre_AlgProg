import java.text.NumberFormat;
import java.util.Locale;

public class Colaborador {

    // Constante que representa o salário base de todos os colaboradores
    public static final double SALARIO_BASE = 2000.00;

    // Atributos privados (encapsulamento)
    private int matricula;
    private String nome;
    private double salarioBase;

    public Colaborador(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.salarioBase = SALARIO_BASE;
    }

    // Getters e setters
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        if (matricula > 0) {
            this.matricula = matricula;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        }
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        if (salarioBase >= 0) {
            this.salarioBase = salarioBase;
        }
    }

    // Retorna o tipo do colaborador (sobrescrito nas subclasses)
    public String getTipo() {
        return "Padrão";
    }

    // Na classe base, o salário final é apenas o salário base
    public double calcularSalarioFinal() {
        return salarioBase;
    }

    // Gancho para as subclasses mostrarem o benefício adicional (comissão/produtividade)
    protected void exibirBeneficio() {
        // Colaborador padrão não possui benefício adicional
    }

    public void exibirDados() {
        System.out.println("Matrícula: " + matricula);
        System.out.println("Nome: " + nome);
        System.out.println("Tipo: " + getTipo());
        System.out.println("Salário Base: " + formatarMoeda(salarioBase));
        exibirBeneficio();
        System.out.println("Salário Final: " + formatarMoeda(calcularSalarioFinal()));
    }

    // Método utilitário reutilizado por todas as classes
    public static String formatarMoeda(double valor) {
        NumberFormat formato = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
        return formato.format(valor);
    }
}
