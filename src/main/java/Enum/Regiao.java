package Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public enum Regiao {
    NORTE("Norte"),
    NORDESTE("Nordeste"),
    SUL("Sul"),
    SUDESTE("Sudeste"),
    LESTE("Leste"),
    SUDOESTE("Sudoeste"),
    OESTE("Oeste"),
    NOROESTE("Noroeste"),
    CENTRO("Centro");

    private String nome;
}
