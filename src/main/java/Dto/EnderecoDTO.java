package Dto;

import Model.Endereco;
import Util.Utils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {

    private String complemento;

    private String numero;

    private String logradouro;

    private String bairro;

    private String localidade;

    private String cep;

    private String categoria;

    public EnderecoDTO(Endereco endereco) {
        this.complemento = endereco.getComplemento();
        this.numero = endereco.getNumero();
        this.logradouro = endereco.getLogradouro();
        if (Utils.isNotEmpty(endereco.getBairro())) {
            this.bairro = endereco.getBairro().getNome();
        }
        this.localidade = "";
        this.cep = endereco.getCep();
        if (Utils.isNotEmpty(endereco.getTipoLogradouro())) {
            this.categoria = endereco.getTipoLogradouro().getNome();
        }
    }

}
