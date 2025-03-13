package Dto;

import Model.Proprietario;
import Util.Utils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConjugeDTO {

    private EnderecoDTO endereco;

    private String razao_social;

    private String nome;

    private String cnpj;

    private Boolean brasileiro;

    private String cpf;

    private String estado_civil;

    private String genero;

    private String rg;

    private String profissao;

    private String data_nascimento;

    private String nome_mae;

    private String nome_pai;

    private String orgaoEmissor;

    private String regime_casamento;

    public ConjugeDTO(Proprietario proprietario) {
        if (Utils.isNotEmpty(proprietario.getEndereco())) {
            this.endereco = new EnderecoDTO(proprietario.getEndereco());
        }

        this.razao_social = proprietario.getRazaoSocial();
        this.nome = proprietario.getNome();
        this.cnpj = proprietario.getCnpj();
        this.cpf = proprietario.getCpf();

        if (Utils.isNotEmpty(proprietario.getEstadoCivil())) {
            this.estado_civil = proprietario.getEstadoCivil().getNome();
        }

        if (Utils.isNotEmpty(proprietario.getSexo())) {
            this.genero = proprietario.getSexo().getNome();
        }

        this.rg = proprietario.getRg();
        this.profissao = proprietario.getProfissao();
        this.data_nascimento = proprietario.getDataNascimento().toString();
        this.nome_mae = proprietario.getFiliacao1();
        this.nome_pai = proprietario.getFiliacao2();
        this.orgaoEmissor = proprietario.getOrgaoEmissor();

        if (Utils.isNotEmpty(proprietario.getRegimeCasamento())) {
            this.regime_casamento = proprietario.getRegimeCasamento().getNome();
        }

    }

}