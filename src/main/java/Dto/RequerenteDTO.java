package Dto;

import Model.Orgao;
import Util.Utils;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequerenteDTO {

    private String nome_apresentante;

    private String numero;

    private String endereco_apresentante;

    private String bairro;

    private String cpf_cnpj_apresentante;

    private String cidade_apresentante;

    private String complemento;

    private String nome_solicitante;

    private String cep_apresentante;

    private String uf_apresentante;

    public RequerenteDTO(Orgao cartorio) {
        this.nome_apresentante = cartorio.getNome();

        if (Utils.isNotEmpty(cartorio.getEnderecoDoOrgao())) {
            this.numero = cartorio.getEnderecoDoOrgao().getNumero();
            this.endereco_apresentante = cartorio.getEnderecoDoOrgao().getLogradouro();
            this.complemento = cartorio.getEnderecoDoOrgao().getComplemento();
            this.cep_apresentante = cartorio.getEnderecoDoOrgao().getCep();
            this.nome_solicitante = cartorio.getNome();

            if (Utils.isNotEmpty(cartorio.getEnderecoDoOrgao().getBairro())) {
                this.bairro = cartorio.getEnderecoDoOrgao().getBairro().getNome();

                if (Utils.isNotEmpty(cartorio.getEnderecoDoOrgao().getBairro().getCidade())) {
                    this.cidade_apresentante = cartorio.getEnderecoDoOrgao().getBairro().getCidade().getNome();

                    if (Utils.isNotEmpty(cartorio.getEnderecoDoOrgao().getBairro().getCidade().getEstado())) {
                        this.uf_apresentante = cartorio.getEnderecoDoOrgao().getBairro().getCidade().getEstado().getUf();
                    }
                }
            }
        }

        if (Utils.isNotEmpty(cartorio.getCnpj())) {
            this.cpf_cnpj_apresentante = cartorio.getCnpj(); 
        } else {
            this.cpf_cnpj_apresentante = cartorio.getCpf();
        }
        
    }
    
}
