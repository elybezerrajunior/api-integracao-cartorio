package Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum TipoPessoa {

    PROPRIETARIO(1, "Proprietario"),
    DEPENDENTE(2, "Dependente"),
    CLIENTE(3, "Cliente"),
    CONJUGE(4, "Cônjuge");

    private Integer valor;
    private String nome;
    
}
