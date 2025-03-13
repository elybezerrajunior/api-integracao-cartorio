package Dto;

import Model.Comodo;
import Util.Utils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComodoDTO {

    private String comodoImovel;

    private String comodoImovelPlural;

    private Integer quantidade;

    public ComodoDTO(Comodo comodo) {
        if (Utils.isNotEmpty(comodo.getTipoComodo())) {
            this.comodoImovel = comodo.getTipoComodo().getNomeSingular();
            this.comodoImovelPlural = comodo.getTipoComodo().getNomePlural();
        }
        this.quantidade = comodo.getQuantidade();
    }

}
