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

    public ClienteController() {
    }

    public Cliente buscaClientePorCPF(String cpf) throws Exception {
        Cliente cliente = new Cliente();

        if(clienteDAO.buscaClientePorCPF(cpf) != null) {
            cliente = clienteDAO.buscaClientePorCPF(cpf);
        }
        else {
            throw new Exception("Não existe cliente com este CPF");
        }
        return cliente;
    }


}
