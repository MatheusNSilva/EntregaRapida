import connection.ConnectionFactory;
import controllers.ClienteController;
import daos.ClienteDAO;
import models.Cliente;

import java.sql.Connection;
import java.sql.SQLException;

public class testeControllerCliente {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        ClienteDAO clienteDAO = new ClienteDAO(connection);
        String resultado = (clienteDAO.buscaClientePorCPF("07874009983")).toString();
        System.out.println(resultado);

        ClienteController clienteController = new ClienteController();
        String controllerTest = (clienteController.buscaClientePorCPF("07874009983").toString());
        System.out.println(controllerTest);

    }
}
