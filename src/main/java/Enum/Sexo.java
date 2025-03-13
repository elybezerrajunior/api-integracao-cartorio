package Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public enum Sexo {

    MASCULINO(
            1, "Masculino", "MA"),
    FEMININO(2, "Feminino", "FE");

    private Integer valor;
    private String nome;
    private String sigla;
    
    public static Sexo valueString(String valor){
        for(Sexo o : values()){
            if(o.getNome().toLowerCase().equals(valor.toLowerCase())){
                return o;
            }
        }
        return null;
    }
}
