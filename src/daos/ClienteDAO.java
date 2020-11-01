package daos;

import java.sql.*;

import models.Cliente;

public class ClienteDAO {

    private Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Cliente cliente) throws SQLClientInfoException {

    }

    public Cliente buscaClientePorCPF(String cpf) throws SQLException {
        String sql = "SELECT * FROM Cliente WHERE CPF = ?";
        Cliente cliente = new Cliente();

        try(PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, cpf);
            pstm.execute();

            try(ResultSet rst = pstm.getResultSet()){

                     cliente = new Cliente(rst.getInt(1),rst.getString(2), rst.getString(3), rst.getTimestamp(4),rst.getBoolean(5),
                                        rst.getString(6), rst.getString(7), rst.getString(8), rst.getInt(9));
            }
        }
        return cliente;
    }
}
