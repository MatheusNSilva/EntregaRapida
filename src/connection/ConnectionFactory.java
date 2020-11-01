package connection;

import java.sql.*;

public class ConnectionFactory {

    public Connection recuperaConexao() throws SQLException, ClassNotFoundException {


        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/entregas?serverTimezone=UTC","root","root");
    }

}
