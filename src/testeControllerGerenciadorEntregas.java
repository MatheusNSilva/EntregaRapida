import connection.ConnectionFactory;
import controllers.EntregadorController;
import controllers.GerenciadorEntregasController;
import controllers.PedidoController;
import daos.ClienteDAO;
import daos.EntregadorDAO;
import models.Cliente;
import models.Entregador;
import models.Pedido;
import models.Status;

import java.sql.Connection;
import java.sql.SQLException;

public class testeControllerGerenciadorEntregas {
    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        GerenciadorEntregasController gerenciadorEntregasController = new GerenciadorEntregasController();
        PedidoController pedidoController = new PedidoController();
        EntregadorController entregadorController = new EntregadorController();
        EntregadorDAO entregadorDAO = new EntregadorDAO(connection);
        ClienteDAO clienteDAO = new ClienteDAO(connection);
        Status status = null;

        Cliente clienteTeste = clienteDAO.buscaClientePorCPF("07874009983");
        Entregador entregadorTeste1 = entregadorDAO.buscaEntregadorPorId(1);
        Entregador entregadorTeste2 = entregadorDAO.buscaEntregadorPorId(1);
        Entregador entregadorTeste3 = entregadorDAO.buscaEntregadorPorId(1);
        Entregador entregadorTeste4 = entregadorDAO.buscaEntregadorPorId(7);

        Pedido  pedidoTeste = new Pedido(clienteTeste, entregadorTeste1, "Arroz 5kg, café, Sorvete", (float) 50.75, clienteTeste.getRegiao(), true, entregadorTeste1.getVeiculo(), 80, status.ABERTO);

        Entregador teste = entregadorDAO.buscaEntregadorPorId(1);
        //gerenciadorEntregasController.adicionaPedidoNaFila(pedidoTeste, pedidoController.verificaPrioridade(clienteTeste));




        //entregadorTeste1 = gerenciadorEntregasController.definiEntregador(entregadorController.verificaEntregadoresHabilitados(clienteTeste.getRegiao(), true, "Carro"), pedidoController.verificaPrioridade(clienteTeste));
        //entregadorTeste2 = gerenciadorEntregasController.definiEntregador(entregadorController.verificaEntregadoresHabilitados(clienteTeste.getRegiao(), false, "Carro"), pedidoController.verificaPrioridade(clienteTeste));
        //entregadorTeste3 = gerenciadorEntregasController.definiEntregador(entregadorController.verificaEntregadoresHabilitados(clienteTeste.getRegiao(), true, "Moto"), pedidoController.verificaPrioridade(clienteTeste));
        entregadorTeste4 = gerenciadorEntregasController.definiEntregador(entregadorController.verificaEntregadoresHabilitados(clienteTeste.getRegiao(), true, "Moto"), pedidoController.verificaPrioridade(clienteTeste));

        System.out.println(entregadorTeste1.toString());
    }
}
