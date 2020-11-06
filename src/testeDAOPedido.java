import connection.ConnectionFactory;
import controllers.ClienteController;
import controllers.EntregadorController;
import daos.ClienteDAO;
import daos.EntregadorDAO;
import daos.PedidoDAO;
import models.Cliente;
import models.Entregador;
import models.Pedido;
import models.Status;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class testeDAOPedido {
    public static void main(String[] args) throws Exception {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        PedidoDAO pedidoDAO = new PedidoDAO(connection);

        ClienteController clienteController = new ClienteController();
        ClienteDAO clienteDAO = new ClienteDAO(connection);
        EntregadorDAO entregadorDAO = new EntregadorDAO(connection);


        Cliente clienteTeste = clienteDAO.buscaClientePorCPF("07874009983");
        Entregador entregadorTeste = entregadorDAO.buscaEntregadorPorId(1);
        System.out.println(entregadorTeste.toString());
        Status status = null;

        Pedido  pedidoTeste = new Pedido(clienteTeste, entregadorTeste, "Arroz 5kg, café, Sorvete", (float) 50.75, clienteTeste.getRegiao(), true, entregadorTeste.getVeiculo(), 80, status.ABERTO);
        pedidoDAO.salvar(pedidoTeste);

    }
}
