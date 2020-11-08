package controllers;

import daos.EntregadorDAO;
import models.Entregador;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntregadorController {

    private Connection connection;
    EntregadorDAO entregadorDAO = new EntregadorDAO(connection);
    List<Entregador> entregadores = new ArrayList<Entregador>();

    public EntregadorController() {
    }

    public boolean verificaEntregadorPorRegiao(String regiao) throws SQLException, ClassNotFoundException {
        if (!entregadorDAO.verificaEntregadoresPorRegiao(regiao)) {
            JOptionPane.showMessageDialog(null,"Não existem entregadores para a região solicitada");
        }
        return entregadorDAO.verificaEntregadoresPorRegiao(regiao);
    }

    public List<Entregador> verificaEntregadoresHabilitados(String regiao, boolean restricao_idade, String veiculo) throws Exception{
        entregadores = entregadorDAO.listaTodos();
        List<Entregador> entregadoresHabilitados = new ArrayList<Entregador>();
        for (int index = 0; index < entregadores.size(); index++) {
            if (regiao.equals(entregadores.get(index).getRegiao()) && veiculo.equals(entregadores.get(index).getVeiculo()) && restricao_idade == entregadores.get(index).isMaior_idade()) {
                entregadoresHabilitados.add(entregadores.get(index));
            }
        }

        if(entregadoresHabilitados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não existe entregador habilitado para essa entrega!");
            throw new Exception("Não existe entregador habilitado para esta entrega");
        }
        else {
            return entregadoresHabilitados;
        }
    }
}
