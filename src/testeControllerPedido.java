import connection.ConnectionFactory;
import controllers.PedidoController;
import daos.ClienteDAO;
import daos.PedidoDAO;
import models.Cliente;

import java.sql.Connection;

public class testeControllerPedido {

    public static void main(String[] args) throws Exception{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        PedidoController pedidoController = new PedidoController();
        PedidoDAO pedidoDAO = new PedidoDAO(connection);
        ClienteDAO  clienteDAO = new ClienteDAO(connection);

        //float total = pedidoController.definiValorTotal((float) 95.5,clienteDAO.buscaClientePorCPF("07874009983"));
        //System.out.println(total);

        //boolean prioridade = pedidoController.verificaPrioridade(clienteDAO.buscaClientePorCPF("07874009983"));
        //System.out.println(prioridade);

        Cliente cliente = clienteDAO.buscaClientePorCPF("07874009983");
        pedidoController.salvar(cliente, "Moto", "Nutella 500g, Nescau 500g, Chocolate Diamante Negro 400g", 30, true);
    }
}
