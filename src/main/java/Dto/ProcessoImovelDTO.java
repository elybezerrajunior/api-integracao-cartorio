package Dto;

import java.util.ArrayList;
import java.util.List;

import Model.Proprietario;
import Util.Utils;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProcessoImovelDTO {

    private List<ProprietarioDTO> interessados;

    private String numero_sei;

    public ProcessoImovelDTO(List<Proprietario> interessados) {

        if (Utils.isNotEmpty(interessados)) {
            this.interessados = new ArrayList<>();
            interessados.forEach(i -> this.interessados.add(new ProprietarioDTO(i)));
        }

        this.numero_sei = "";
    }

}
