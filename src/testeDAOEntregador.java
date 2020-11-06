import connection.ConnectionFactory;
import daos.EntregadorDAO;
import models.Entregador;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class testeDAOEntregador {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        EntregadorDAO entregadorDAO = new EntregadorDAO(connection);

       // ArrayList<Entregador> entregadores = entregadorDAO.buscaEntregadoresHabilitados(true,  "Moto");
       // System.out.println(entregadores);
       // Entregador entregador = new Entregador();
       //

        List<Entregador> entregadorList = new  ArrayList<Entregador>();
        //entregadorList = entregadorDAO.buscaEntregadoresHabilitados(true, "Moto", "Rio Vermelho");
        //entregadorList.stream().forEach(le -> System.out.println(le));

        //entregadorList = entregadorDAO.listaTodos();
        //entregadorList.stream().forEach(le -> System.out.println(le));

        //boolean test = entregadorDAO.verificaEntregadoresPorRegiao("jij");
        //System.out.println(test);

        //entregadorList = entregadorDAO.buscaEntregadoresHabilitados(true,"Moto", "Rio Vermelho");
        //entregadorList.stream().forEach(le -> System.out.println(le));

        Entregador entregador = entregadorDAO.buscaEntregadorPorId(1);
        System.out.println(entregador.toString());
    }
}
