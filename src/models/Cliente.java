/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

/**
 *
 * @author mathe
 */
public class Cliente {
    private int total_pedidos;
    private int documento;
    private String nome;
    private int idade;
    private String endereco;
    private String telefone;
    private String regiao;

    public Cliente() {
    }

    public Cliente(int total_pedidos, int documento, String nome, int idade, String endereco, String telefone, String regiao) {
        this.total_pedidos = total_pedidos;
        this.documento = documento;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.telefone = telefone;
        this.regiao = regiao;
    }

    public int getTotal_pedidos() {
        return total_pedidos;
    }

    public void setTotal_pedidos(int total_pedidos) {
        this.total_pedidos = total_pedidos;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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
}
