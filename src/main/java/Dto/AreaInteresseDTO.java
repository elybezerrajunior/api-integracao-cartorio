package Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AreaInteresseDTO  {

    private TipoAreaInteresseDTO tipo;

    private String nome;

    private String cadastro_estadual;

    public AreaInteresseDTO(String areaInteresse) {
        this.tipo = new TipoAreaInteresseDTO(areaInteresse);
        this.nome = areaInteresse;
    }

}
