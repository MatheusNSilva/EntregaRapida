import connection.ConnectionFactory;
import views.RegistroPedidoView;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class testeViewRegistroPedido {

    public static void main(String[] args) throws Exception {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();
        RegistroPedidoView registroPedidoView = new RegistroPedidoView("Teste");
        registroPedidoView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        registroPedidoView.setVisible(true);
    }
}
