package controllers;

import daos.PedidoDAO;
import models.Cliente;
import models.Entregador;
import models.Pedido;
import models.Status;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PedidoController {

    Connection connection;
    PedidoDAO pedidoDAO = new PedidoDAO(connection);
    EntregadorController entregadorController = new EntregadorController();
    GerenciadorEntregasController gerenciadorEntregasController = new GerenciadorEntregasController();
    Status status;

    public PedidoController() {
    }

    public float definiValorTotal(float valor_pedido, Cliente cliente) {
        float valor_total = 0;
        if ((cliente.getTotal_pedidos() % 5) == 0) {
            valor_total = valor_pedido;
        }
        else {
            valor_total = valor_pedido + fretePorRegiao(cliente.getRegiao());

        }
        return valor_total
    }

    public float fretePorRegiao(String regiao) {
        float valor_frete = 0;
         switch (regiao) {
             case "Trindade":
                 valor_frete = 5;
                 break;
             case "Centro":
                 valor_frete = 15;
                 break;
             case "Carvoeira":
                 valor_frete = 8;
                 break;
             case "João Paulo":
                 valor_frete = 15;
                 break;
             case "Pantanal":
                 valor_frete = 8;
                 break;
             case "Ingleses":
                 valor_frete = 20;
                 break;
             case "Rio Vermelho":
                 valor_frete = 25;
                 break;
             case "Lagoa":
                 valor_frete = 15;
                 break;
             case "Tapera":
                 valor_frete = 30;
                 break;
         }

        return valor_frete;
    }

    public boolean verificaPrioridade(Cliente cliente) {
        if(cliente.isPrioritario()) {
            return true;
        }
        else {
            return false;
        }
    }

    public void salvar(Cliente cliente, String veiculo, String lista_itens, float valor_pedido, boolean restricao_idade) throws Exception {
        float valor_total = definiValorTotal(valor_pedido, cliente);
        Entregador entregador = new Entregador();
        entregador = definiEntregadorParaEntrega(entregadorController.verificaEntregadoresHabilitados(cliente.getRegiao(), restricao_idade, veiculo));
        //Pedido pedidoRegistrado = new Pedido(cliente, entregador, lista_itens, restricao_idade, cliente.getRegiao(), .);
        //gerenciadorEntregasController.adicionaPedidoNaFila(pedidoRegistrado, verificaPrioridade(cliente));
        //pedidoDAO.salvar(pedidoRegistrado);

    }

    public Entregador definiEntregadorParaEntrega(List<Entregador> entregadores) {
        Entregador entregadorSelecionado = new Entregador();

        return entregadorSelecionado;
    }

}