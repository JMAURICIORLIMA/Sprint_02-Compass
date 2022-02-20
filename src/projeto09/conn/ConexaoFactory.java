package projeto09.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoFactory {

    public static Connection getConexao() {
        String url = "jdbc:mysql://localhost:3306/loja_compass?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "*BeE.171@*";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection) {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Connection connection, Statement smt){
        close(connection);
        try {
            if (smt != null)
                smt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
