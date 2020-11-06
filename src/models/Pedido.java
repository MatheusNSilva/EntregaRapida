package models;

import java.sql.Timestamp;

public class Pedido {

    private int id;
    private Cliente cliente;
    private  Entregador entregador;
    private String lista_itens;
    private float valor_pedido;
    private String regiao;
    private Timestamp registro_lancamento;
    private boolean restricao_idade;
    private String veiculo;
    private float valor_total;
    private Status status;

    public Pedido() {
    }

    public Pedido(Cliente cliente, Entregador entregador, String lista_itens, float valor_pedido, String regiao, boolean restricao_idade, String veiculo, float valor_total, Status status) {
        this.cliente = cliente;
        this.entregador = entregador;
        this.lista_itens = lista_itens;
        this.valor_pedido = valor_pedido;
        this.regiao = regiao;
        this.restricao_idade = restricao_idade;
        this.veiculo = veiculo;
        this.valor_total = valor_total;
        this.status = status;
    }

    public Pedido(int id, Cliente cliente, Entregador entregador, String lista_itens, float valor_pedido, String regiao, boolean restricao_idade, String veiculo, float valor_total, Status status) {
        this.id = id;
        this.cliente = cliente;
        this.entregador = entregador;
        this.lista_itens = lista_itens;
        this.valor_pedido = valor_pedido;
        this.regiao = regiao;
        this.restricao_idade = restricao_idade;
        this.veiculo = veiculo;
        this.valor_total = valor_total;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Entregador getEntregador() {
        return entregador;
    }

    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }

    public String getLista_itens() {
        return lista_itens;
    }

    public void setLista_itens(String lista_itens) {
        this.lista_itens = lista_itens;
    }

    public float getValor_pedido() {
        return valor_pedido;
    }

    public void setValor_pedido(float valor_pedido) {
        this.valor_pedido = valor_pedido;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public Timestamp getRegistro_lancamento() {
        return registro_lancamento;
    }

    public void setRegistro_lancamento(Timestamp registro_lancamento) {
        this.registro_lancamento = registro_lancamento;
    }

    public boolean getRestricao_idade() {
        return restricao_idade;
    }

    public void setRestricao_idade(boolean restricao_idade) {
        this.restricao_idade = restricao_idade;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", entregador=" + entregador +
                ", lista_itens='" + lista_itens + '\'' +
                ", valor_pedido=" + valor_pedido +
                ", regiao='" + regiao + '\'' +
                ", registro_lancamento=" + registro_lancamento +
                ", restricao_idade=" + restricao_idade +
                ", veiculo='" + veiculo + '\'' +
                ", valor_total=" + valor_total +
                ", status='" + status + '\'' +
                '}';
    }

}
