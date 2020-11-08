import connection.ConnectionFactory;
import controllers.GerenciadorEntregasController;
import models.Pedido;
import views.RegistroPedidoView;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class testeViewRegistroPedido {

    public static void main(String[] args) throws Exception {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();
        RegistroPedidoView registroPedidoView = new RegistroPedidoView("Teste");
        registroPedidoView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GerenciadorEntregasController gerenciadorEntregasController = new GerenciadorEntregasController();
        gerenciadorEntregasController.povoaListas();

        List<Pedido> entregasList = gerenciadorEntregasController.retornaLista();
        entregasList.stream().forEach(le -> System.out.println(le));

        registroPedidoView.setVisible(true);
    }
}
