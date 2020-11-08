package daos;

import connection.ConnectionFactory;
import models.Cliente;
import models.Entregador;
import models.Pedido;
import models.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorEntregasDAO {

    private Connection connection;

    public GerenciadorEntregasDAO(Connection connection) {
        this.connection = connection;
    }
    ClienteDAO clienteDAO = new ClienteDAO(null);
    EntregadorDAO entregadorDAO = new EntregadorDAO(null);
    Status status;

    public List<Pedido> listaTodos() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM pedido;";
        List<Pedido> pedidos = new ArrayList<Pedido>();

        try {
            connection = ConnectionFactory.recuperaConexao();
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.execute();

            try (ResultSet rst = pstm.getResultSet()){
                while (rst.next()) {
                    Cliente cliente = clienteDAO.buscaClientePorId(rst.getInt(2));
                    Entregador entregador = entregadorDAO.buscaEntregadorPorId(rst.getInt(3));
                    Pedido pedido = new Pedido(rst.getInt(1), cliente, entregador, rst.getString(4), rst.getBoolean(5), rst.getTimestamp(6), rst.getString(7),
                            status.valueOf(rst.getString(8)), rst.getString(9), rst.getFloat(10), rst.getFloat(11));

                    pedidos.add(pedido);
                }
            }
        } finally {
            ConnectionFactory.fechaConexao(connection);
        }
        return pedidos;
    }

    public Pedido buscaPedidoPeloId(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM pedido WHERE id = ?;";
        Pedido pedido = new Pedido();

        try {
            connection = ConnectionFactory.recuperaConexao();
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();

            try (ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    Cliente cliente = clienteDAO.buscaClientePorId(rst.getInt(2));
                    Entregador entregador = entregadorDAO.buscaEntregadorPorId(rst.getInt(3));
                    pedido = new Pedido(rst.getInt(1), cliente, entregador, rst.getString(4), rst.getBoolean(5), rst.getTimestamp(6), rst.getString(7),
                            status.valueOf(rst.getString(8)), rst.getString(9), rst.getFloat(10), rst.getFloat(11));

                }
            }
        }
        finally {
            ConnectionFactory.fechaConexao(connection);
        }
        return pedido;
    }
}
