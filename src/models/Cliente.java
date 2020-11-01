/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.Timestamp;

/**
 *
 * @author mathe
 */
public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private Timestamp idade;
    private boolean prioritario;
    private String endereco;
    private String telefone;
    private String regiao;
    private int total_pedidos;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, Timestamp idade, boolean prioritario, String endereco, String telefone, String regiao, int total_pedidos) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.prioritario = prioritario;
        this.endereco = endereco;
        this.telefone = telefone;
        this.regiao = regiao;
        this.total_pedidos = total_pedidos;
    }

    public Cliente(int id, String nome, String cpf, Timestamp idade, boolean prioritario, String endereco, String telefone, String regiao, int total_pedidos) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.prioritario = prioritario;
        this.endereco = endereco;
        this.telefone = telefone;
        this.regiao = regiao;
        this.total_pedidos = total_pedidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Timestamp getIdade() {
        return idade;
    }

    public void setIdade(Timestamp idade) {
        this.idade = idade;
    }

    public boolean isPrioritario() {
        return prioritario;
    }

    public void setPrioritario(boolean prioritario) {
        this.prioritario = prioritario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public int getTotal_pedidos() {
        return total_pedidos;
    }

    public void setTotal_pedidos(int total_pedidos) {
        this.total_pedidos = total_pedidos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                ", prioritario=" + prioritario +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", regiao='" + regiao + '\'' +
                ", total_pedidos=" + total_pedidos +
                '}';
    }
}
