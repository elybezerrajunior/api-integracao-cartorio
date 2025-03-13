package Enum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public enum TipoEdificacao {
    CASA(1, "Casa"),
    APARTAMENTO(2, "Apartamento");


    private Integer valor;
    private String nome;

    TipoEdificacao(Integer valor, String nome) {
        this.valor = valor;
        this.nome = nome;
    }
    
    public static TipoEdificacao valueString(String valor){
        for(TipoEdificacao o : values()){
            if(o.getNome().toLowerCase().equals(valor.toLowerCase())){
                return o;
            }
        }
        return null;
    }
}
