import connection.ConnectionFactory;
import daos.ClienteDAO;
import models.Cliente;

import java.sql.Connection;
import java.sql.SQLException;

public class testeDaoCliente {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        ClienteDAO clienteDAO = new ClienteDAO(connection);

        //Cliente cliente = new Cliente("Baltazar Silva","07947858893", "1993-05-08 00:00.01", false,"Rua Rio Ponche nº104", "(48)37884509", "Rio Vermelho", 0);
        //String resultado = (clienteDAO.buscaClientePorCPF("07874009983")).toString();
        //String resultadoBuscaID = (clienteDAO.buscaClientePorId(1)).toString();
        //System.out.println(resultadoBuscaID);
        String resultado = (clienteDAO.buscaClientePorCPF("8888888888")).toString();
        System.out.println(resultado);
    }


}
