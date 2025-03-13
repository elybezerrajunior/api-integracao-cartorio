package Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public  enum Escolaridade {
    ANALFABETO(
    "Analfabeto"), 
    ALFABETIZADO("Alfabetizado"),
    ENSINO_FUNDAMENTAL_INCOMPLETO("Ensino Fundamental Incompleto"), 
    ENSINO_FUNDAMENTAL("Ensino Fundamental"),
    ENSINO_MEDIO_INCOMPLETO("Ensino Médio Incompleto"), 
    ENSINO_MEDIO("Ensino Médio"),
    SUPERIOR_INCOMPLETO("Superior Incompleto"), 
    SUPERIOR("Superior"),
    MESTRADO("Mestrado"), 
    DOUTORADO("Doutorado");

    private String nome;
    
    public static Escolaridade valueString(String valor){
        for(Escolaridade o : values()){
            if(o.getNome().toLowerCase().equals(valor.toLowerCase())){
                return o;
            }
        }
        return null;
    }
}
