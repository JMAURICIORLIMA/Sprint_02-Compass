package projeto09.conn.jdbc.test.db;

import projeto09.classes.Produto;
import projeto09.conn.ConexaoFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
    String sql;
    Connection conn;
    Statement smt;

    public void insere(Produto produto) {
        sql = "INSERT INTO `loja_compass`.`produtos` (`NOME`, `DESCRICAO`, `DESCONTO`,`PK_ID`) VALUES ('"
                + produto.getNome() + "', '" + produto.getDescricao() + "', '" + produto.getDesconto() + "', '" + produto.getPk_id() + "')";
        conn = ConexaoFactory.getConexao();
        try {
            smt = conn.createStatement();
            smt.executeUpdate(sql);
            System.out.println("Registro inserido com sucesso. ");
        } catch (SQLException e) {
            System.out.println("Produto existente: " + e.getMessage() + "Verificando necessidade de atualização. ");
            upedate(produto);
        } finally {
            ConexaoFactory.close(conn, smt);
        }
    }

    public void delete(Integer idProduto) {
        if (idProduto == null) {
            System.out.println("Não foi possível excluir. Produto inexistente. ");
            return;
        }
        try {
            sql = "DELETE FROM `loja_compass`.`produtos` WHERE (`PK_ID` = '" + idProduto + "');";
            conn = ConexaoFactory.getConexao();
            smt = conn.createStatement();
            smt.executeUpdate(sql);
            System.out.println("Registo excluído com sucesso. ");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoFactory.close(conn, smt);
        }

    }
    public void upedate(Produto produto) {
        if (produto == null || produto.getPk_id() == null) {
            System.out.println("Não foi possível atualizar o registro. ");
            return;
        }
        try {
            sql = "UPDATE `loja_compass`.`produtos` SET `NOME` = '" + produto.getNome() + "'," +
                    " `DESCRICAO` = '" + produto.getDescricao() + "'," +
                    " `DESCONTO` = '" + produto.getDesconto() + "'," +
                    " `PK_ID` = '" + produto.getPk_id() + "' WHERE (`PK_ID` = '" + produto.getPk_id() + "')";

            conn = ConexaoFactory.getConexao();
            smt = conn.createStatement();
            smt.executeUpdate(sql);
            System.out.println("Registo alterado com sucesso. ");
        } catch (SQLException e) {
            System.out.println("ID do produto inexistente, ERRO: " + e.getMessage() + "Inserindo este produto. ");
            insere(produto);
        } finally {
            ConexaoFactory.close(conn, smt);
        }
    }

//    public void select (Produto produto) {
//        sql = "SELECT * FROM `loja_compass`.`produtos` WHERE `DESCRICAO` LIKE ;";
//        conn = ConexaoFactory.getConexao();
//        try {
//            smt = conn.createStatement();
//            ResultSet resultSet = smt.executeQuery(sql);
//            while (resultSet.next()){
//                resultSet.getInt();
//            }
//        } catch (SQLException e) {
//            System.out.println("Produto existente: " + e.getMessage() + "Verificando necessidade de atualização. ");
//            upedate(produto);
//        } finally {
//            ConexaoFactory.close(conn, smt);
//        }
//    }
}
