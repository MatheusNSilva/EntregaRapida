package models;

public enum Veiculo {

    CARRO("Carro"),
    MOTO("Moto"),
    BICICLETA("Bicicleta");

    private String veiculo;

    Veiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getVeiculo() {
        return veiculo;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "veiculo='" + veiculo + '\'' +
                '}';
    }
}
