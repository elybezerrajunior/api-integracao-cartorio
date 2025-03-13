package Enum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public enum StatusLote {

    DESVINCULADO(1, "Desvinculado", "DE", "#f4f4efe0"),
    VINCULADO(2, "Vinculado", "VI", "#2196F3"),
    INDEFERIDO(3, "Indeferido", "IN", "#ff0854"),
    REGULARIZADO(4, "Regularizado", "RE", "#4caf4f"),
    GERADO_REMESSA(5, "Gerado Remessa", "GR", "#84cf1b"),
    CASA_FECHADA_RECUSADA(6, "Casa Fechada ou Recusada", "FR", "#1bcfc3");

    private Integer valor;
    private String nome;
    private String sigla;
    private String cor;

    private StatusLote(Integer valor, String nome, String sigla, String cor) {
        this.valor = valor;
        this.nome = nome;
        this.sigla = sigla;
        this.cor = cor;
    }

}
