package controllers;
import daos.ClienteDAO;
import models.Cliente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;


public class ClienteController {

    private ArrayList<Cliente> clientes = new ArrayList();
    private Connection connection;
    private ClienteDAO clienteDAO = new ClienteDAO(connection);

    public ClienteController() throws SQLException {
    }

    public Cliente buscaClientePorCPF(String cpf) throws Exception {
        Cliente cliente = clienteDAO.buscaClientePorCPF(cpf);

        if(cliente != null) {
            return cliente;
        }
        else {
            throw new Exception("Não existe cliente com este CPF");
        }
    }


}
