package Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public enum TipoShape {

    NUCLEO(1, "Nucleo", "#FF0000", 6, "#FF0000"),
    LOGRADOURO(2, "Logradouro", "#008ae6", 5, "#008ae6"),
    EDIFICACAO(3, "Edificação", "#fc9d9d", 4, "#ff0000"),
    LOTE(4, "Lote", "green", 3, "green"),
    QUADRA(5, "Quadra", "#f2cfa2", 2, "#cc4400"),
    BAIRRO(6, "Bairro", "#e6ac00", 1, "#e6ac00"),
    AREA_VERDE(7, "Área Verde", "#034f1e", 7, "#034f1e"),
    AREA_INSTITUCIONAL(8, "Área Institucional", "#8c5103", 7, "#8c5103");

    private Integer valor;
    private String nome;
    private String cor;
    private String corDestaque;
    private int prioridade;

    private TipoShape(Integer valor, String nome, String cor, int prioridade, String corDestaque) {
        this.valor = valor;
        this.nome = nome;
        this.cor = cor;
        this.corDestaque = corDestaque;
        this.prioridade = prioridade;
    }

    public static TipoShape valueString(String valor) {
        for (TipoShape o : values()) {
            if (o.getNome().equals(valor)) {
                return o;
            }
        }
        return null;
    }

    public boolean usaArea() {
        return this.equals(QUADRA) || this.equals(LOTE) || this.equals(EDIFICACAO);
    }

}
