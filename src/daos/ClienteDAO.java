package daos;

import java.sql.*;

import connection.ConnectionFactory;
import models.Cliente;

import javax.swing.*;

public class ClienteDAO {

    Connection connection;


    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Cliente cliente) throws SQLClientInfoException {
       String sql = "INSERT INTO cliente (nome, cpf, idade, prioritario, endereco, telefone, regiao, total_pedidos) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getCpf());
            pstm.setTimestamp(3, cliente.getIdade());
            pstm.setBoolean(4, cliente.isPrioritario());
            pstm.setString(5, cliente.getEndereco());
            pstm.setString(6, cliente.getTelefone());
            pstm.setString(7, cliente.getRegiao());
            pstm.setInt(8, cliente.getTotal_pedidos());

            pstm.execute();

            try (ResultSet rst = pstm.getGeneratedKeys()) {
                while (rst.next()) {
                    cliente.setId(rst.getInt(1));
                }
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Cliente buscaClientePorCPF(String cpf) throws SQLException, Exception {
        String sql = "SELECT * FROM Cliente WHERE CPF = ?";
        Cliente cliente = new Cliente();

        try {
            connection = ConnectionFactory.recuperaConexao();
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, cpf);
            pstm.execute();

            try(ResultSet rst = pstm.getResultSet()){
                    if (rst != null) {
                        while (rst.next()) {
                            cliente = new Cliente(rst.getInt(1),rst.getString(2), rst.getString(3), rst.getTimestamp(4),rst.getBoolean(5),
                                    rst.getString(6), rst.getString(7), rst.getString(8), rst.getInt(9));
                        }
                    }
            }
        } finally {
            ConnectionFactory.fechaConexao(connection);
        }
        if(cliente.getNome() == null) {
            JOptionPane.showMessageDialog(null,"Não existe cliente com este CPF");
        }
        return cliente;
    }

    public Cliente buscaClientePorId(int id) throws SQLException {
        String sql = "SELECT * FROM Cliente WHERE id = ?";
        Cliente cliente = new Cliente();

        try(PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, id);
            pstm.execute();

            try(ResultSet rst = pstm.getResultSet()){
                if (rst != null) {
                    while (rst.next()) {
                        cliente = new Cliente(rst.getInt(1),rst.getString(2), rst.getString(3), rst.getTimestamp(4),rst.getBoolean(5),
                                rst.getString(6), rst.getString(7), rst.getString(8), rst.getInt(9));
                    }
                }
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return cliente;
    }

    /*public void transformaResultEmCliente(Cliente cliente ,PreparedStatement pstm) throws SQLException {
        try (ResultSet rst = pstm.getResultSet()) {
            if (rst != null) {
                while (rst.next()) {
                    cliente = new Cliente(rst.getInt(1),rst.getString(2), rst.getString(3), rst.getTimestamp(4),rst.getBoolean(5),
                            rst.getString(6), rst.getString(7), rst.getString(8), rst.getInt(9));
                }
            }
        }
    }*/
}

