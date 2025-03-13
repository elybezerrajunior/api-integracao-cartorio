package Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public enum Patrimonio {

    MUNICIPIO(1, "Município"),
    ESTADO(2, "Estado"),
    UNIAO(3, "União"),
    PARTICULAR(4, "Particular");

    private Integer valor;
    private String nome;


}
