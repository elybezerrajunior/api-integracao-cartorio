package Dto;

import Model.Estado;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EstadoDTO {

    private Long id;

    private String nome;

    private String uf;

    private int versao;

    private Boolean ativo;

    public EstadoDTO(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.uf = estado.getUf();
        this.versao = estado.getVersion();
        this.ativo = estado.getAtivo();
    }

}
