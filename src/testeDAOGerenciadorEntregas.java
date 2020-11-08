import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import daos.GerenciadorEntregasDAO;
import models.Pedido;

public class testeDAOGerenciadorEntregas {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        GerenciadorEntregasDAO gerenciadorEntregasDAO = new GerenciadorEntregasDAO(connection);

        List<Pedido> entregasList = new ArrayList<Pedido>();
        entregasList = gerenciadorEntregasDAO.listaTodos();
        entregasList.stream().forEach(le -> System.out.println(le));

        Pedido pedido = gerenciadorEntregasDAO.buscaPedidoPeloId(1);
        System.out.println(pedido.toString());

    }
}
