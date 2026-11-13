import javax.swing.*;

public class Main {

    public static int menu(){
        String txt = "1) Adicionar Produto \n";
        txt += "2) Imprimir Lista \n";
        txt += "3) Remover último \n";
        txt += "0) Sair \n\n";
        txt += "Digite sua opção: ";

        String resposta = JOptionPane.showInputDialog(txt);
        if(resposta.isEmpty()){
            return -1;
        }
        return Integer.parseInt(resposta);
    }

    public static void main(String[] args) {
        Lista listProd = new Lista();

        int opcao;
        do {
            opcao = menu();
            switch (opcao) {
                case 1:
                    Produto newProd = new Produto();
                    newProd.nome = JOptionPane.showInputDialog("Nome do Produto: ");
                    String qtd = JOptionPane.showInputDialog("Quantidade: ");
                    if(qtd.isEmpty())newProd.quantidade = 0;
                    else
                        newProd.quantidade = Integer.parseInt(qtd);
                    listProd.add(newProd);
                    break;

                case 2:
                    listProd.imprimir();
                    break;

                case 3:
                    listProd.produtos.removeLast();
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Até logo!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
            }
        }while (opcao != 0);

    }

//        Produto p1 = new Produto("Chocolate", 5);
//
//        if (listProd.add(p1)) {
//            JOptionPane.showMessageDialog(null, "Adicionou o P1");
//        }else{
//            JOptionPane.showMessageDialog(null, "Não adicionou o P1");
//        }
//
//        listProd.add(new Produto("Coca-Cola", 2));



}