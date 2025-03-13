package Model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Enum.Escolaridade;
import Enum.Nacionalidade;
import Enum.Sexo;
import Enum.TipoDocumento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Proprietario extends Pessoa {

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Proprietario conjuge;

    @Column(scale = 2, precision = 10)
    private BigDecimal rendaMensal;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Enumerated(EnumType.STRING)
    private Escolaridade escolaridade;

    @Enumerated(EnumType.STRING)
    private Nacionalidade nacionalidade;
    
    private String naturalidade;
    
    private String cadUnico;   

    @ManyToMany(mappedBy = "proprietarios", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Edificacao> edificacoes;

    @ManyToMany(mappedBy = "proprietarios", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Imovel> imoveis;

    public Proprietario() {
        this.sexo = Sexo.MASCULINO;
    }

    @JsonIgnore
    public String getDocumentoProprietario() {
        return super.getDocumento();
    }
    
    @JsonIgnore
    public boolean isValido() {
        boolean result = false;
        if (TipoDocumento.CPF.equals(getTipoDocumento())) {
            if (getNome() != null && !getNome().isEmpty()) {
                result = true;
            }
        } else {
            if (getRazaoSocial() != null && !getRazaoSocial().isEmpty()) {
                result = true;
            }
        }
        return result;
    }
}
