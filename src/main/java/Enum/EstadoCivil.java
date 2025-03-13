package Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public enum EstadoCivil {

    SOLTEIRO(1, "Solteiro(a)", "SOLTEIRO", false),
    CASADO(2, "Casado(a)", "CASADO", true),
    DIVORCIADO(3, "Divorciado(a)", "DIVORCIADO", false),
    VIUVO(4, "Viúvo(a)", "VIUVO", false),
    UNIAO_ESTAVEL(6, "União estável", "UNIAO_ESTAVEL", true),
    SEPARADO_JUDICIALMENTE(7, "Separado judicialmente", "SEPARADO_JUDICIALMENTE", false),
    CASADO_SEPARADO_CORPOS(8, "Casado(a) - Separado de Corpos", "SEPARADO_CORPOS", false),
    DESQUITADO(9, "Desquitado", "DESQUITADO", false),
    OUTRO(5, "Outro", null, false);

    private String nome;
    private Integer valor;
    private String nomeNotario;
    private boolean temConjuge;

    private EstadoCivil(Integer valor, String nome, String nomeNotario, boolean temConjuge) {
        this.valor = valor;
        this.nome = nome;
        this.nomeNotario = nomeNotario;
        this.temConjuge = temConjuge;
    }    
    
    public static EstadoCivil valueString(String valor){
        for(EstadoCivil o : values()){
            if(o.getNome().toLowerCase().equals(valor.toLowerCase())){
                return o;
            }
        }
        return null;
    }

}
