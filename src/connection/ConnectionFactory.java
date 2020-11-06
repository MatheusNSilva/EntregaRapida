package connection;

import java.sql.*;

public class ConnectionFactory {

    private static Connection connection;

    public static Connection recuperaConexao() throws SQLException, ClassNotFoundException {

        connection  = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/entregas?serverTimezone=UTC","root","root");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void fechaConexao(Connection connection) {

        if (connection != null){
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
