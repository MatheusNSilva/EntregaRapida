package controllers;

import daos.EntregadorDAO;
import models.Entregador;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class EntregadorController {

    private Connection connection;
    EntregadorDAO entregadorDAO = new EntregadorDAO(connection);


}
