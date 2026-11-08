import javax.swing.*;
import java.util.Scanner;

public class Main {

    private static int menu(){
     String txt = "1) Mostrar Saldo";
     txt += "\n2) Depositar";
     txt += "\n3) Sacar";
     txt += "\n0) Sair";
     txt += "\n\nDigite sua opção:";
        return Integer.parseInt(JOptionPane.showInputDialog(txt));

    }
    public static void main(String[] args) {

        String txt = "Qual tipo de cliente \n(1) Físico\n(2) Jurídico";
        int tipoCliente = Integer.parseInt(JOptionPane.showInputDialog(txt));

        Cliente cliente = null;
        // String nome = JOptionPane.showInputDialog("Nome do cliente: ");
        if (tipoCliente == 1){
        //     String cpf = JOptionPane.showInputDialog("CPF: ");
            cliente = new Fisico();
        } else {
        //    String cnpj = JOptionPane.showInputDialog("CNPJ: ");
            cliente = new Juridico();
        }
        cliente.cadastrar();

        txt = "Qual tipo de conta: \n(1) Poupança\n(2) Corrente";
        int tipoConta = Integer.parseInt(JOptionPane.showInputDialog(txt));

        Conta c1 = null;

        if (tipoConta == 1)
            c1 = new Poupanca();
        } else c1 = new Corrente();

        c1.titular = cliente;

        int op = -1;

        while(op != 0){
            op = menu();
            switch(op){
                case 1:
                    JOptionPane.showMessageDialog(null, "Saldo: " + c1.getSaldo());
                    break;
                case 2:

                    double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor a depositar: "));
                    c1.depositar(valor);
                    break;
                case 3:
                    c1.sacar( Double.parseDouble(JOptionPane.showInputDialog("Valor a sacar:") ) );
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Bye-Bye");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
            }
        }

        }

    }