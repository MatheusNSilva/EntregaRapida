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
public class Entregador {
    private String nome;
    private int idade;
    private String cnh;
    private Veiculo veiculo;
    private String telefone;
    private Regiao regiao;

    public Entregador(String nome, int idade, String cnh, Veiculo veiculo, String telefone, Regiao regiao) {
        this.nome = nome;
        this.idade = idade;
        this.cnh = cnh;
        this.veiculo = veiculo;
        this.telefone = telefone;
        this.regiao = regiao;
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

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public Regiao getRegião() {
        return regiao;
    }

    public void setRegião(Regiao regiao) {
        this.regiao = regiao;
    }
}
