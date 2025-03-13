package Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TipoServicoDTO {

    private String codigo;

    public TipoServicoDTO(String codigo) {
        this.codigo = codigo;
    }

}
