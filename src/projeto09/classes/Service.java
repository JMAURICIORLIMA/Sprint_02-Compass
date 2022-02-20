package projeto09.classes;

import projeto09.conn.jdbc.test.db.Dao;

import java.util.Scanner;

public class Service {
    static Scanner scanner = new Scanner(System.in);

    public static void insere(){
        Produto produto = new Produto();

        System.out.println("Digite o ID do produto: ");
        produto.setPk_id(scanner.nextInt());
        System.out.println("Informe o DESCONTO do produto: ");
        produto.setDesconto(scanner.nextDouble());
        System.out.println("Informe o NOME do produto: ");
        produto.setNome(scanner.next());
        System.out.println("Informe a DESCRIÇÃO do produto: ");
        produto.setDescricao(scanner.next());

        Dao dao = new Dao();
        dao.insere(produto);

    }

    public static void atualiza(){
        Produto produto = new Produto();

        System.out.println("Digite o ID do produto: ");
        produto.setPk_id(scanner.nextInt());
        System.out.println("Informe o DESCONTO do produto: ");
        produto.setDesconto(scanner.nextDouble());
        System.out.println("Informe o NOME do produto: ");
        produto.setNome(scanner.next());
        System.out.println("Informe a DESCRIÇÃO do produto: ");
        produto.setDescricao(scanner.next());


        Dao dao = new Dao();
        dao.upedate(produto);
    }

    public static void delete(){
        System.out.println("Digite o ID do produto: ");
        Integer idProduto = scanner.nextInt();
        Dao dao = new Dao();
        dao.delete(idProduto);
    }



}
