package controllers;
import models.Cliente;
import models.Regiao;

import java.util.ArrayList;


public class Cliente_controller {

    private ArrayList<Cliente> clientes = new ArrayList();

    public Cliente_controller() {
    }

    public void cadastrar_cliente(int total_pedidos, int documento, String nome, int idade, String endereco, String telefone, String regiao) {
        Cliente novoCliente = new Cliente(total_pedidos, documento, nome, idade, endereco, telefone, regiao);
        int idade_minima = 16;

        if (documento != 0 && !nome.isEmpty() && idade >= idade_minima && !endereco.isEmpty() && !telefone.isEmpty() && !regiao.isEmpty()) {
            clientes.add(clientes.size(), novoCliente);
        } else {
            throw new Error("Cliente não tem idade mínima necessaria");
        }
    }

    public ArrayList<Cliente> listar_clientes() {
        return clientes;
    }

    public Cliente remover_cliente(int documento) {
        Cliente cliente_removido = new Cliente();
        for(int posicoes = 0; posicoes < clientes.size(); posicoes++) {
            if (clientes.get(posicoes).getDocumento() == documento){
                cliente_removido = clientes.get(posicoes);
                clientes.remove(posicoes);
            }
        }
        return cliente_removido;

    }

    public Cliente atualizar_cliente(Cliente cliente) {
        Cliente cliente_atualizado = new Cliente();
        for(int posicoes = 0; posicoes < clientes.size(); posicoes++) {
            if (clientes.get(posicoes).getDocumento() == cliente.getDocumento()){
                cliente_atualizado = clientes.get(posicoes);
                clientes.add(posicoes, cliente);
            }
        }
        return cliente_atualizado;
    }
}
