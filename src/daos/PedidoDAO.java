package daos;

import connection.ConnectionFactory;
import models.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PedidoDAO {

    private Connection connection;
    private ClienteDAO clienteDAO = new ClienteDAO(connection);
    private EntregadorDAO entregadorDAO = new EntregadorDAO(connection);

    public PedidoDAO(Connection connection) throws SQLException {
        this.connection = connection;
    }

    public PedidoDAO() throws SQLException {
    }

    public void salvar(Pedido pedido) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO pedido (id_cliente, id_entregador ,lista_itens, restricao_idade, regiao, status, veiculo, valor_pedido, valor_total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            connection = ConnectionFactory.recuperaConexao();
            PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, pedido.getCliente().getId());
            pstm.setInt(2, pedido.getEntregador().getId());
            pstm.setString(3, pedido.getLista_itens());
            pstm.setBoolean(4, pedido.getRestricao_idade());
            pstm.setString(5, pedido.getRegiao());
            pstm.setString(6, pedido.getStatus().toString());
            pstm.setString(7, pedido.getVeiculo());
            pstm.setFloat(8, pedido.getValor_pedido());
            pstm.setFloat(9, pedido.getValor_total());

            pstm.execute();

            try (ResultSet rst = pstm.getGeneratedKeys()) {
                while (rst.next()) {
                    pedido.setId(rst.getInt(1));
                }
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }

        } finally {
            ConnectionFactory.fechaConexao(connection);
        }
    }

    public ArrayList<Pedido> listar() throws SQLException {
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        String sql = "select p.id, c.nome, e.nome, p.status from pedido p\n" +
                "inner join cliente c on p.id_cliente = c.id\n" +
                "inner join entregador e on p.id_entregador = e.id\n" +
                "where p.status != 'FECHADO';";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.execute();

            try (ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    //Pedido pedido = new Pedido(rst.getInt(1), clienteDAO.buscaClientePorId(rst.getInt(2)), entregadorDAO.buscaEntregadorPorId(rst.getInt(3)), rst.getString(4), rst.getBoolean(5),
                            //rst.getTimestamp(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getFloat(10), rst.getFloat(11));

                    //pedidos.add(pedido);
                }
            }
        }
        return pedidos;
    }

}
