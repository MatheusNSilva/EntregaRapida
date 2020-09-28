package models;

public enum Regiao {

    TRINDADE ("Trindade"),
    CENTRO ("Centro"),
    CARVOEIRA ("Carvoeira"),
    JOAO_PAULO ("João Paulo"),
    PANTANAL ("Pantanal"),
    INGLESES ("Ingleses"),
    RIO_VERMELHO ("Rio Vermelho"),
    LAGOA ("Lagoa"),
    TAPERA ("Tapera");


    private String regiao;

    Regiao(String regiao) {
        this.regiao = regiao;
    }

    public  String getRegiao() {
        return regiao;
    }

    @Override
    public String toString() {
        return this.regiao;
    }
}
