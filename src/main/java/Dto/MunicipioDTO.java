package Dto;

import Model.Cidade;
import Util.Utils;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MunicipioDTO {

    private Long id;

    private String nome;

    private int versao;

    private Boolean ativo;

    private String codIbge;

    private EstadoDTO estado;

    public MunicipioDTO(Cidade cidade) {
        this.id = cidade.getId();
        this.nome = cidade.getNome();
        this.versao = cidade.getVersion();
        this.ativo = cidade.getAtivo();
        this.codIbge = cidade.getCodIbge();
        if (Utils.isNotEmpty(cidade.getEstado())) {
            this.estado = new EstadoDTO(cidade.getEstado());
        }
    }

}
