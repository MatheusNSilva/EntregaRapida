package controllers;

import models.Cliente;
import models.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoController {

    List<Pedido> lista_comum = new ArrayList<Pedido>();
    List<Pedido> lista_prioritaria = new ArrayList<Pedido>();

    public void definiValorTotal(float valor_pedido, Cliente cliente) {
        float valor_total = 0;
        if ((cliente.getTotal_pedidos() % 5) == 0) {
            valor_total = valor_pedido;
        }
        else {
            valor_total = valor_pedido + fretePorRegiao(cliente.getRegiao());

        }
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

    public void verificaPrioridade(Cliente cliente, Pedido pedido) {
        if(cliente.isPrioritario()) {
            lista_prioritaria.add(pedido);
        }
        else {
            lista_comum.add(pedido);
        }
    }

}