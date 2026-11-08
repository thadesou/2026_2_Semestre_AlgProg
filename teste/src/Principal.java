import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    private static final Scanner teclado = new Scanner(System.in);
    private static final ArrayList<Colaborador> colaboradores = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ", 0);

            switch (opcao) {
                case 1:
                    cadastrarPadrao();
                    break;
                case 2:
                    cadastrarComissionado();
                    break;
                case 3:
                    cadastrarProducao();
                    break;
                case 4:
                    gerarFolhaPagamento();
                    break;
                case 5:
                    exibirResumoFolha();
                    break;
                case 0:
                    System.out.println("Até uma próxima!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        teclado.close();
    }

    // ---------------- MENU ----------------

    private static void exibirMenu() {
        System.out.println();
        System.out.println("***** SISTEMA DE FOLHA DE PAGAMENTO ******");
        System.out.println("1 - Cadastrar Colaborador Padrão");
        System.out.println("2 - Cadastrar Colaborador Comissionado");
        System.out.println("3 - Cadastrar Colaborador Produção");
        System.out.println("4 - Gerar Folha de Pagamento");
        System.out.println("5 - Exibir Resumo da Folha");
        System.out.println("0 - Sair");
    }

    // ---------------- CADASTROS DE COLABORADORES ----------------

    private static void cadastrarPadrao() {
        System.out.println("\n*** Cadastro de Colaborador Padrão ***");
        int matricula = lerMatricula();
        String nome = lerNome("Nome: ");

        colaboradores.add(new ColaboradorPadrao(matricula, nome));
        System.out.println("Colaborador cadastrado com sucesso!");
    }

    private static void cadastrarComissionado() {
        System.out.println("\n*** Cadastro de Colaborador Comissionado ***");
        int matricula = lerMatricula();
        String nome = lerNome("Nome: ");
        double vendas = lerDouble("Valor de vendas (R$): ", 0, Double.MAX_VALUE);
        double percentual = lerDouble("Percentual de comissão (0 a 100): ", 0, 100);

        colaboradores.add(new ColaboradorComissionado(matricula, nome, vendas, percentual));
        System.out.println("Colaborador cadastrado com sucesso!");
    }

    private static void cadastrarProducao() {
        System.out.println("\n*** Cadastro de Colaborador Produção ***");
        int matricula = lerMatricula();
        String nome = lerNome("Nome: ");
        int pecas = lerInteiro("Quantidade de peças: ", 0);
        double valorPeca = lerDouble("Valor por peça (R$): ", 0, Double.MAX_VALUE);

        colaboradores.add(new ColaboradorProducao(matricula, nome, pecas, valorPeca));
        System.out.println("Colaborador cadastrado com sucesso!");
    }

    // ---------------- FOLHA E RESUMO ----------------

    private static void gerarFolhaPagamento() {
        System.out.println("\n****** FOLHA DE PAGAMENTO ******");

        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum colaborador cadastrado.");
            return;
        }

        for (Colaborador c : colaboradores) {
            c.exibirDados();
            System.out.println("------------------------------");
        }
    }

    private static void exibirResumoFolha() {
        System.out.println("\n****** RESUMO DA FOLHA ******");

        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum colaborador cadastrado.");
            return;
        }

        System.out.println("Quantidade de colaboradores: " + colaboradores.size());
        System.out.println("Soma total da folha: " + Colaborador.formatarMoeda(calcularTotalFolha()));
        System.out.println("Média salarial: " + Colaborador.formatarMoeda(calcularMediaSalarial()));
    }

    // Métodos adicionais (reutilização de código)
    private static double calcularTotalFolha() {
        double total = 0;
        for (Colaborador c : colaboradores) {
            total += c.calcularSalarioFinal();
        }
        return total;
    }

    private static double calcularMediaSalarial() {
        if (colaboradores.isEmpty()) {
            return 0;
        }
        return calcularTotalFolha() / colaboradores.size();
    }

    // ---------------- LEITURA E VALIDAÇÃO DE DADOS ----------------

    private static int lerMatricula() {
        while (true) {
            int matricula = lerInteiro("Matrícula: ", 1);
            if (matriculaExiste(matricula)) {
                System.out.println("Já existe um colaborador com essa matrícula.");
            } else {
                return matricula;
            }
        }
    }

    private static boolean matriculaExiste(int matricula) {
        for (Colaborador c : colaboradores) {
            if (c.getMatricula() == matricula) {
                return true;
            }
        }
        return false;
    }

    private static String lerNome(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String nome = teclado.nextLine().trim();

            if (nome.isEmpty()) {
                System.out.println("O nome não pode ficar vazio.");
            } else if (!nome.matches("\\p{L}+( \\p{L}+)*")) {
                System.out.println("Nome inválido! Use apenas letras (A-Z) e espaços.");
            } else {
                return nome;
            }
        }
    }

    private static int lerInteiro(String mensagem, int minimo) {
        while (true) {
            System.out.print(mensagem);
            try {
                int valor = Integer.parseInt(teclado.nextLine().trim());
                if (valor >= minimo) {
                    return valor;
                }
                System.out.println("Informe um valor maior ou igual a " + minimo + ".");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número inteiro.");
            }
        }
    }

    private static double lerDouble(String mensagem, double minimo, double maximo) {
        while (true) {
            System.out.print(mensagem);
            try {
                String entrada = teclado.nextLine().trim().replace(",", ".");
                double valor = Double.parseDouble(entrada);
                if (valor >= minimo && valor <= maximo) {
                    return valor;
                }
                System.out.println("Valor fora do intervalo permitido.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número.");
            }
        }
    }
}
