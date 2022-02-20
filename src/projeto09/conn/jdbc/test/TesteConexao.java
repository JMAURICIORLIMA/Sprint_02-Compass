package projeto09.conn.jdbc.test;

import projeto09.classes.Service;

import java.util.Scanner;

public class TesteConexao {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Boolean condicao = false;

        int entrada;

        while (!condicao) {
            System.out.println("============== System ==============" +
                    "\nDigite a opção desejada: " +
                    "\n1 - para INSERIR uma nova oferta" +
                    "\n2 - para ATUALIZAR uma oferta" +
                    "\n3 - para DELETAR uma nova oferta" +
                    "\n4 - para listar as palavras que contem ?" +
                    "\n0 - para SAIR");

            entrada = scanner.nextInt();

            switch (entrada){
                case 1:
                    Service.insere();
                    break;
                case 2:
                    Service.atualiza();
                    break;
                case 3:
                    Service.delete();
                    break;
                case 4:

                    break;

                case 0:
                    condicao = true;
                    break;
                default:
                    System.out.println("Opção inválida. ");
            }

        }
    }
}
