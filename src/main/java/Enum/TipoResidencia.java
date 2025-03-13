package Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public enum TipoResidencia {

    UNIFAMILIAR(1, "Unifamiliar"),
    MULTIFAMILIAR(2, "Multifamiliar");

    private int numero;
    private String nome;
    
    
    public static TipoResidencia valueString(String valor){
        for(TipoResidencia o : values()){
            if(o.getNome().toLowerCase().equals(valor.toLowerCase())){
                return o;
            }
        }
        return null;
    }
  
}
