package Model;

import java.sql.Date;
import java.util.Objects;

import Enum.Escolaridade;
import Enum.EstadoCivil;
import Enum.Nacionalidade;
import Enum.Sexo;
import Enum.TipoDocumento;
import Enum.TipoPessoa;
import Util.Caracteres;
import Util.Utils;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProprietarioAtual extends Pessoa {

    private String instituicao;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Enumerated(EnumType.STRING)
    private Nacionalidade nacionalidade;

    public ProprietarioAtual(String instituicao) {
        this.instituicao = instituicao;
    }

    public ProprietarioAtual() {
    }

    public ProprietarioAtual(Proprietario proprietario) {
        if (Utils.isNotEmpty(proprietario)) {
            // this.instituicao = proprietario.getIn
            this.sexo = proprietario.getSexo();
            this.nacionalidade = proprietario.getNacionalidade();
            setNome(proprietario.getNome());
            setCpf(proprietario.getCpf());
            setCnpj(proprietario.getCnpj());
            setNomeFantasia(proprietario.getNomeFantasia());
            setRazaoSocial(proprietario.getRazaoSocial());
            setEmail(proprietario.getEmail());
            setDataNascimento(proprietario.getDataNascimento());
            setTipoDocumento(proprietario.getTipoDocumento());
            setRg(proprietario.getRg());
            setOrgaoEmissor(proprietario.getOrgaoEmissor());
            setProfissao(proprietario.getProfissao());
            setTelefone(proprietario.getTelefone());
            setFiliacao1(proprietario.getFiliacao1());
            setFiliacao2(proprietario.getFiliacao2());
            setDataObito(proprietario.getDataObito());
            setLivroCertidaoObito(proprietario.getLivroCertidaoObito());
            setTermoCertidaoObito(proprietario.getTermoCertidaoObito());
            setMatriculaCertidaoObito(proprietario.getMatriculaCertidaoObito());
            setFolhaCertidaoObito(proprietario.getFolhaCertidaoObito());
            setHoraObito(proprietario.getHoraObito());
            setEspolio(proprietario.getEspolio());
            setEstadoCivil(proprietario.getEstadoCivil());
            setRegimeCasamento(proprietario.getRegimeCasamento());
            setEndereco(proprietario.getEndereco());
            setTipoPessoa(proprietario.getTipoPessoa());
        }
    }

    public ProprietarioAtual(Orgao orgao) {
        if (Utils.isNotEmpty(orgao)) {
            setNome(orgao.getNome());
            setCpf(orgao.getCpf());
            setCnpj(orgao.getCnpj());
            setRazaoSocial(orgao.getRazaoSocial());
            setEmail(orgao.getEmail());
            setDataNascimento(orgao.getDataNascimento());
            setTipoDocumento(orgao.getTipoDocumento());
            setTelefone(orgao.getTelefone());
        }
    }

    public ProprietarioAtual(String instituicao, Long id, String nome, String filiacao2, String nomePai, String rg, String cpf, String cnpj, Nacionalidade nacionalidade, String profissao, Date dataNasc, Date dataObito, TipoPessoa tipoPessoa, TipoDocumento tipoDocumento, String nomeFantasia, String nomeSocial, String razaoSocial, Sexo sexo, EstadoCivil estadoCivil, Escolaridade escolaridade, String telefone, boolean brasileiro, String email, Endereco endereco, Pais paisNascimento, Etnia etnia, Genero genero, OrientacaoSexual orientacaoSexual, String orgaoEmissor, boolean mesmoEnderecoImovel, boolean mesmoEnderecoEdificacao) {
        this.instituicao = instituicao;
    }

    public String getMacroProprietarioAtual() {
        String texto = "";
        if (Utils.isNotEmpty(getTipoDocumento())) {
            if (getTipoDocumento().equals(TipoDocumento.CPF)) {
                boolean mulher = false;
                boolean mulherConjuge = false;

                if (Utils.isNotEmpty(getSexo())) {
                    mulher = getSexo().equals(Sexo.FEMININO);
                }
                if (Utils.isNotEmpty(getNome())) {
                    texto += "<strong>" + getNome() + "</strong>, ";
                }
                if (nacionalidade == Nacionalidade.BRASILEIRO) {
                    if (!mulher) {
                        texto += "brasileiro, ";
                    } else {
                        texto += "brasileira, ";
                    }
                }
                if (Utils.isNotEmpty(getEstadoCivil())) {
                    texto += getEstadoCivil().getNomeNotario();
                    if (mulher) {
                        texto += "a, ";
                    } else {
                        texto += "o, ";
                    }
                }
                if (Utils.isNotEmpty(getProfissao())) {
                    texto += getProfissao() + ",";
                }
                if (mulher) {
                    texto += "portadora da carteira de identidade RG nº ";
                } else {
                    texto += "portador da carteira de identidade RG nº ";
                }
                if (Utils.isNotEmpty(getRg())) {
                    texto += getRg() + " ";
                }
                if (Utils.isNotEmpty(getOrgaoEmissor())) {
                    texto += getOrgaoEmissor() + ", ";
                }
                if (mulher) {
                    texto += "inscrita no CPF sob nº ";
                } else {
                    texto += "inscrito no CPF sob nº ";
                }
                if (Utils.isNotEmpty(getCpf())) {
                    texto += Utils.addMascaraCpf(Caracteres.removeCaracteresEspeciais(getCpf())) + ", ";
                }
                if (mulher) {
                    texto += "filha de ";
                } else {
                    texto += "filho de ";
                }
                if (Utils.isNotEmpty(getFiliacao1())) {
                    texto += getFiliacao1();
                    if (Utils.isNotEmpty(getFiliacao2())) {
                        texto += " e de " + getFiliacao2();
                    }
                }

                if (Utils.isNotEmpty(getEndereco())) {
                    if (Utils.isNotEmpty(getEndereco().getTipoLogradouro())) {
                        texto += getEndereco().getTipoLogradouro().getNome();
                        if (Utils.isNotEmpty(getEndereco().getLogradouro())) {
                            texto += " " + getEndereco().getLogradouro() + ", ";
                        }
                    }
                    if (Utils.isNotEmpty(getEndereco().getNumero())) {
                        texto += "N° " + getEndereco().getNumero() + ", ";
                    }
                    if (Utils.isNotEmpty(getEndereco().getBairro())) {
                        texto += getEndereco().getBairro().getNome() + ", ";
                    }
                    if (Utils.isNotEmpty(getEndereco().getBairro())) {
                        texto += "na cidade de " + getEndereco().getBairro().getCidade().getNome() + "-" + getEndereco().getBairro().getCidade().getEstado().getUf();
                    }
                }
            } else {
                if (Utils.isNotEmpty(getRazaoSocial())) {
                    texto += getRazaoSocial() + ", ";
                } else if (Utils.isNotEmpty(getNomeFantasia())) {
                    texto += getNomeFantasia() + ", ";
                }
                if (Utils.isNotEmpty(getCnpj())) {
                    texto += "inscrito no CNPJ nº " + Utils.addMascaraCnpj(Caracteres.removecaracter(getCnpj())) + ", ";
                }
                if (Utils.isNotEmpty(getEndereco())) {
                    if (Utils.isNotEmpty(getEndereco().getTipoLogradouro())) {
                        texto += "com sede na " + getEndereco().getTipoLogradouro().getNome() + " ";
                    }
                    if (Utils.isNotEmpty(getEndereco().getLogradouro())) {
                        texto += getEndereco().getLogradouro() + ", ";
                    }
                    if (Utils.isNotEmpty(getEndereco().getNumero())) {
                        texto += getEndereco().getNumero() + ", ";
                    }
                    if (Utils.isNotEmpty(getEndereco().getCep())) {
                        texto += Utils.addMascaraCep(Caracteres.removecaracter(getEndereco().getCep())) + ", ";
                    }
                    if (Utils.isNotEmpty(getEndereco().getBairro())) {
                        if (Utils.isNotEmpty(getEndereco().getBairro().getCidade())) {
                            texto += "na cidade de " + getEndereco().getBairro().getCidade().getNome() + "-" + getEndereco().getBairro().getCidade().getEstado().getUf();
                        }
                    }

                }
            }
        }
        return texto;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.instituicao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProprietarioAtual other = (ProprietarioAtual) obj;
        return Objects.equals(this.instituicao, other.instituicao);
    }

    @Override
    public String toString() {
        return "ProprietarioAtual{" + "instituicao=" + instituicao + '}';
    }

}

