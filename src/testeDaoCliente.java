import connection.ConnectionFactory;
import daos.ClienteDAO;
import models.Cliente;

import java.sql.Connection;
import java.sql.SQLException;

public class testeDaoCliente {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        ClienteDAO clienteDAO = new ClienteDAO(connection);


        String resultado = (clienteDAO.buscaClientePorCPF("07874009983")).toString();
        System.out.println(resultado);
    }
}
