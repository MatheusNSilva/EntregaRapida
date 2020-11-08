package controllers;

import daos.GerenciadorEntregasDAO;
import models.Entregador;
import models.Pedido;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorEntregasController {

    Connection connection;
    GerenciadorEntregasDAO gerenciadorEntregasDAO = new GerenciadorEntregasDAO(connection);
    List<Pedido> lista_comum = new ArrayList<Pedido>();
    List<Pedido> lista_prioritaria = new ArrayList<Pedido>();

    public GerenciadorEntregasController() {
    }

    public List<Pedido> retornaLista(){
        return lista_prioritaria;
    }

    public void povoaListas() throws SQLException, ClassNotFoundException {
        List<Pedido> todosPedidos = gerenciadorEntregasDAO.listaTodos();
        for (int posicao = 0; todosPedidos.size() > posicao; posicao++) {
            if (todosPedidos.get(posicao).getCliente().isPrioritario() == true) {
                lista_prioritaria.add(todosPedidos.get(posicao));
            } else {
                lista_comum.add(todosPedidos.get(posicao));
            }
        }
    }

    public void adicionaPedidoNaFila(Pedido pedido, boolean prioridade) {
        if (prioridade) {
            lista_prioritaria.add(pedido);
            System.out.println("Prioritario");
        } else {
            lista_comum.add(pedido);
            System.out.println("Comum");
        }

    }

    public Entregador definiEntregador(List<Entregador> entregadores, boolean prioridade) {
        List<Entregador> entregadoresIndisponiveis = new ArrayList<Entregador>();
        Entregador entregadorSelecionado = new Entregador();
        if (prioridade) {
            if (lista_prioritaria.isEmpty()) {
                entregadorSelecionado = entregadores.get(0);
            } else {
                for(int posicao = 0; posicao < lista_prioritaria.size(); posicao++) {
                    for(int entregadorIndex = 0; entregadorIndex < entregadores.size(); entregadorIndex++) {
                        if((lista_prioritaria.get(posicao).getEntregador()).equals(entregadores.get(entregadorIndex))){
                            entregadoresIndisponiveis.add(entregadores.get(entregadorIndex));
                        }
                    }
                }
                if (entregadoresIndisponiveis.containsAll(entregadores)) {
                    entregadorSelecionado = entregadoresIndisponiveis.get(entregadoresIndisponiveis.size()-1);
                }
                else {
                    int index = 0;
                    while (entregadoresIndisponiveis.size() > entregadores.size()) {
                        index --;
                        if (!entregadoresIndisponiveis.contains(entregadores.get(entregadores.size()-index))) {
                            entregadorSelecionado = entregadores.get(entregadores.size()-index);
                        }
                    }
                }
            }

        } else {
            if (lista_comum.isEmpty()) {
                entregadorSelecionado = entregadores.get(0);
            } else {
                for(int posicao = 0; posicao < lista_comum.size(); posicao++) {
                    for(int entregadorIndex = 0; entregadorIndex < entregadores.size(); entregadorIndex++) {
                        if((lista_comum.get(posicao).getEntregador()).equals(entregadores.get(entregadorIndex))){
                            entregadoresIndisponiveis.add(entregadores.get(entregadorIndex));
                        }
                    }
                }
                if (entregadoresIndisponiveis.containsAll(entregadores)) {
                    entregadorSelecionado = entregadoresIndisponiveis.get(entregadoresIndisponiveis.size()-1);
                }
                else {
                    int index = 0;
                    while (entregadoresIndisponiveis.size() > entregadores.size()) {
                        index --;
                        if (!entregadoresIndisponiveis.contains(entregadores.get(entregadores.size()-index))) {
                            entregadorSelecionado = entregadores.get(entregadores.size()-index);
                            break;
                        }
                    }
                }
            }
        }

        return entregadorSelecionado;
    }

}
