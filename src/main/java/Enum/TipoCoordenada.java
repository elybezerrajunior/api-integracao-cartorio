package Enum;

public enum TipoCoordenada {
    LATITUDE_LOGITUDE(1, "Latitude e Longitude"),
    UTM(2, "UTM"),
    DMS(3,  "Graus, minutos e segundos"),
    AZIMUTE(4,  "Azimute");
    
    private String nome;
    private Integer valor;

    private TipoCoordenada(Integer valor, String nome) {
        this.valor = valor;
        this.nome = nome;
    }
}
