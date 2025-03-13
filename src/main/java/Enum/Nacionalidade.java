package Enum;

import lombok.Getter;

@Getter
public enum Nacionalidade {

    BRASILEIRO(1, "Brasileiro(a)", "BRASILEIRO"),
    ESTRANGEIRO(2, "Estrangeiro(a)", "ESTRANGEIRO");

    private Integer valor;
    private final String nome;
    private final String descricao;

    private Nacionalidade(Integer valor, String nome, String descricao) {
        this.valor = valor;
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public static Nacionalidade valueString(String valor){
        for(Nacionalidade o : values()){
            if(o.getNome().toLowerCase().equals(valor.toLowerCase())){
                return o;
            }
        }
        return null;
    }

  

}
