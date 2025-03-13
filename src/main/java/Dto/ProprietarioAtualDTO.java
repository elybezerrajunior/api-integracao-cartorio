package Dto;

import Model.Orgao;
import Util.Utils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProprietarioAtualDTO {
    
    private String cidade;

    private String estado;

    private String endereco;

    private String codigo_ibge_cidade;

    private String bairro;

    private String instituicao;

    private String numero_endereco;

    private String cnpj;

    private String cep;

    public ProprietarioAtualDTO(Orgao cartorio) {

        this.instituicao = cartorio.getNome();
        this.cnpj = cartorio.getCnpj();

        if (Utils.isNotEmpty(cartorio.getEnderecoDoOrgao())) {
            this.endereco = cartorio.getEnderecoDoOrgao().getLogradouro();
            this.numero_endereco = cartorio.getEnderecoDoOrgao().getNumero();
            this.cep = cartorio.getEnderecoDoOrgao().getCep();

            if (Utils.isNotEmpty(cartorio.getEnderecoDoOrgao().getBairro())) {
                this.bairro = cartorio.getEnderecoDoOrgao().getBairro().getNome();

                if (Utils.isNotEmpty(cartorio.getEnderecoDoOrgao().getBairro().getCidade())) {
                    this.cidade = cartorio.getEnderecoDoOrgao().getBairro().getCidade().getNome();
                    this.codigo_ibge_cidade = cartorio.getEnderecoDoOrgao().getBairro().getCidade().getCodIbge();

                    if (Utils.isNotEmpty(cartorio.getEnderecoDoOrgao().getBairro().getCidade().getEstado())) {
                        this.estado = cartorio.getEnderecoDoOrgao().getBairro().getCidade().getEstado().getUf();
                    }
                }
            }
        }
    }

}
