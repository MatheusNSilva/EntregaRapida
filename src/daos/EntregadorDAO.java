package daos;

import connection.ConnectionFactory;
import models.Cliente;
import models.Entregador;
import models.Veiculo;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class EntregadorDAO {

    private Connection connection;

    public EntregadorDAO() {};

    public EntregadorDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Entregador> listaTodos() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM entregador;";
        List<Entregador> entregadores = new ArrayList<Entregador>();

        try {
            connection = ConnectionFactory.recuperaConexao();
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.execute();

            try (ResultSet rst = pstm.getResultSet()){
                while (rst.next()) {
                    Entregador entregador = new Entregador(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6),
                            rst.getBoolean(7), rst.getString(8));

                    entregadores.add(entregador);
                }
            }
        } finally {
            ConnectionFactory.fechaConexao(connection);
        }
        return entregadores;
    }

    public Entregador buscaEntregadorPorId(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM entregador WHERE id = ?";
        Entregador entregador = new Entregador();

        try {
            connection = ConnectionFactory.recuperaConexao();
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();

            try(ResultSet rst = pstm.getResultSet()){
                if (rst != null) {
                    while (rst.next()) {
                        entregador = new Entregador(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6),
                                rst.getBoolean(7), rst.getString(8));
                    }
                }
            }
        } finally {
            ConnectionFactory.fechaConexao(connection);
        }

        return entregador;
    }

    public boolean verificaEntregadoresPorRegiao(String regiao) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM entregador WHERE regiao LIKE ?";
        boolean existe = false;
        List<Entregador> entregadores = new ArrayList<Entregador>();

        try {
            connection = ConnectionFactory.recuperaConexao();
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, regiao);
            pstm.execute();

            try(ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    Entregador entregador = new Entregador(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6),
                            rst.getBoolean(7), rst.getString(8));
                    entregadores.add(entregador);
                }
            }
        } finally {
            ConnectionFactory.fechaConexao(connection);
        }

        if (entregadores.isEmpty())
            JOptionPane.showMessageDialog(null, "Não existe entregador cadastrado para região solicitada");
        else
            existe = true;

        return existe;
    }

    public List<Entregador> buscaEntregadoresHabilitados(boolean restricao_idade, String veiculo, String regiao) throws SQLException, ClassNotFoundException {
        List<Entregador> entregadoresHabilitados = new ArrayList<Entregador>();
        List<Entregador> entregadorList = new  ArrayList<Entregador>();
        EntregadorDAO entregadorDAO = new EntregadorDAO(connection);
        entregadorList = entregadorDAO.listaTodos();
        entregadorList.stream().forEach(entregador -> {
            if (entregador.isMaior_idade() == restricao_idade && entregador.getVeiculo().equals(veiculo) && entregador.getRegiao().contains(regiao)) {
                entregadoresHabilitados.add(entregador);
            }
        });
        if (entregadoresHabilitados.isEmpty())
            JOptionPane.showMessageDialog(null, "Não existe entregador habilitado para esta entrega");

        return entregadoresHabilitados;
    }
}
