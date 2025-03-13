package Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TipoAreaInteresseDTO {

    private String categoria;

    private String nome;

    public TipoAreaInteresseDTO(String nome) {
        this.nome = nome;
        this.categoria = "ASS";
    }

}
