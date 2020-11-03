import connection.ConnectionFactory;
import daos.PedidoDAO;
import models.Pedido;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class testeDAOPedido {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        PedidoDAO pedidoDAO = new PedidoDAO(connection);

        Pedido pedido = new Pedido();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        pedidos = pedidoDAO.listar();
        //for(int i = 0; i< pedidos.size(); i++) {
        //    System.out.println(pedidos.toString());
        //}

    }
}
