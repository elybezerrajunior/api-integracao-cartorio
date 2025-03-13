package Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public enum TipoAnexoCategoria {
    PESSOA_FISICA,
    PESSOA_JURIDICA,
    AMBOS;
    
    private String nome;

}
