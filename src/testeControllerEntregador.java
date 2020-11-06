import connection.ConnectionFactory;
import controllers.EntregadorController;
import daos.EntregadorDAO;
import models.Entregador;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class testeControllerEntregador {
    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        EntregadorController entregadorController = new EntregadorController();
        EntregadorDAO entregadorDAO = new EntregadorDAO(connection);

        //boolean naRegiao = entregadorController.verificaEntregadorPorRegiao("Centro");
        //System.out.println(naRegiao);

        List<Entregador> habilitados = new ArrayList<Entregador>();
        habilitados = entregadorController.verificaEntregadoresHabilitados("Trindade", true, "Moto");
        habilitados.stream().forEach(hb -> System.out.println(hb));
        //entregadorList = entregadorDAO.buscaEntregadoresHabilitados(true, "Moto", "Rio Vermelho");
        //entregadorList.stream().forEach(le -> System.out.println(le));

    }
}
