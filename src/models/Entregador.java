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
    private int id;
    private String cpf;
    private String nome;
    private String regiao;
    private boolean maior_idade;
    private String cnh;
    private String veiculo;
    private String telefone;


    public Entregador() {
    }

    public Entregador(String nome, String cpf, String telefone, String regiao, String veiculo, boolean maior_idade, String cnh) {
        this.nome = nome;
        this.maior_idade = maior_idade;
        this.cnh = cnh;
        this.cpf = cpf;
        this.veiculo = veiculo;
        this.telefone = telefone;
        this.regiao = regiao;
    }

    public Entregador(int id, String nome, String cpf, String telefone, String regiao, String veiculo, boolean maior_idade, String cnh) {
        this.id = id;
        this.nome = nome;
        this.maior_idade = maior_idade;
        this.cnh = cnh;
        this.cpf = cpf;
        this.veiculo = veiculo;
        this.telefone = telefone;
        this.regiao = regiao;
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

    public boolean isMaior_idade() {
        return maior_idade;
    }

    public void setMaior_idade(boolean maior_idade) {
        this.maior_idade = maior_idade;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
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

    @Override
    public String toString() {
        return "Entregador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", regiao='" + regiao + '\'' +
                ", veiculo=" + veiculo +
                ", maior_idade=" + maior_idade +
                ", cnh='" + cnh + '\'' +
                '}';
    }
}
