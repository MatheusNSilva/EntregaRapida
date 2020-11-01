package controllers;
import models.Cliente;
import models.Regiao;

import java.sql.Timestamp;
import java.util.ArrayList;


public class Cliente_controller {

    private ArrayList<Cliente> clientes = new ArrayList();

    public Cliente_controller() {
    }

    public Cliente_controller(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void cadastrar_cliente(String nome, String cpf, Timestamp idade, boolean prioritario, String endereco, String telefone, String regiao, int total_pedidos) {
        Cliente novoCliente = new Cliente(nome, cpf, idade, prioritario, endereco, telefone, regiao, total_pedidos);
        int idade_minima = 16;
        /*
        if (cpf != 0 && !nome.isEmpty() && idade >= idade_minima && !endereco.isEmpty() && !telefone.isEmpty() && !regiao.isEmpty()) {
            clientes.add(clientes.size(), novoCliente);
        } else {
            throw new Error("Cliente não tem idade mínima necessaria");
        }*/
    }

    public ArrayList<Cliente> listar_clientes() {
        return clientes;
    }

    public Cliente remover_cliente(String cpf) {
        Cliente cliente_removido = new Cliente();
        for(int posicoes = 0; posicoes < clientes.size(); posicoes++) {
            if (clientes.get(posicoes).getCpf() == cpf){
                cliente_removido = clientes.get(posicoes);
                clientes.remove(posicoes);
            }
        }
        return cliente_removido;

    }

    public Cliente atualizar_cliente(Cliente cliente) {
        Cliente cliente_atualizado = new Cliente();
        for(int posicoes = 0; posicoes < clientes.size(); posicoes++) {
            if (clientes.get(posicoes).getCpf() == cliente.getCpf()){
                cliente_atualizado = clientes.get(posicoes);
                clientes.add(posicoes, cliente);
            }
        }
        return cliente_atualizado;
    }
}
