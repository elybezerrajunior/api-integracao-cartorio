package Model;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Enum.EstadoCivil;
import Enum.RegimeCasamento;
import Enum.TipoDocumento;
import Enum.TipoPessoa;
import Util.Caracteres;
import Util.Utils;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends EntidadeGenerica {
    
    @Id
    @SequenceGenerator(sequenceName = "seq_pessoa", name = "seq_pessoa", allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    private String cpf;
    private String cnpj;
    private String nomeFantasia;
    private String razaoSocial;
    private String email;
    private Date dataNascimento;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    private String rg;
    private String orgaoEmissor;
    private String profissao;
    private String telefone;
    private String filiacao1;
    private String filiacao2;

    private Date dataObito;
    private String livroCertidaoObito;
    private String termoCertidaoObito;
    private String matriculaCertidaoObito;
    private String folhaCertidaoObito;
    private String horaObito;
    private Boolean espolio;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @Enumerated(EnumType.STRING)
    private RegimeCasamento regimeCasamento;

    @OneToOne(fetch = FetchType.LAZY)
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    public Pessoa() {
        this.tipoDocumento = TipoDocumento.CPF;
        this.estadoCivil = EstadoCivil.SOLTEIRO;
    }

    @JsonIgnore
    public String getDocumento() {
        if (getTipoDocumento() == null) {
            return "";
        } else {
            switch (getTipoDocumento()) {
                case CPF:
                    Caracteres.removeCaracteresEspeciais(getCpf());
                    return getCpf() != null ? Caracteres.addMask(getCpf(), Caracteres.cpfMask) : "";
                case CNPJ:
                    Caracteres.removeCaracteresEspeciais(getCnpj());
                    return getCnpj() != null ? Caracteres.addMask(getCnpj(), Caracteres.cnpjMask) : "";
                default:
                    return "";
            }
        }
    }

    @JsonIgnore
    public String getNomePessoa() {
        if (Utils.isNotEmpty(tipoDocumento)) {
            if (Utils.isNotEmpty(cpf) && !cpf.toLowerCase().equals("null")) {
                if (Utils.isNotEmpty(nome)) {
                    return nome;
                }
            } else {
                if (Utils.isNotEmpty(razaoSocial) && !razaoSocial.toLowerCase().equals("null")) {
                    return razaoSocial;
                } else {
                    return nomeFantasia;
                }
            }
        }
        return "";
    }

    @JsonIgnore
    public String getNomeProprietario() {

        if (null == getTipoDocumento()) {
            return "";
        } else {
            switch (getTipoDocumento()) {
                case CPF:
                    return getNome();
                case CNPJ:
                    return getRazaoSocial();
                default:
                    return "";
            }
        }

    }

    @JsonIgnore
    public String setNomeProprietario() {

        if (null == getTipoDocumento()) {
            return "";
        } else {
            switch (getTipoDocumento()) {
                case CPF:
                    return getNome();
                case CNPJ:
                    return getRazaoSocial();
                default:
                    return "";
            }
        }

    }
}
