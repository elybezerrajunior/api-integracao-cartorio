package Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Util.Utils;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ImovelBackup extends EntidadeGenerica {
    
    
    @Id
    @SequenceGenerator(sequenceName = "seq_imovelBackup", name = "seq_imovelBackup", allocationSize = 1)
    @GeneratedValue(generator = "seq_imovelBackup", strategy = GenerationType.SEQUENCE)
    private Long id;
    /*app*/
    private String quadra;
    private String lote;

    /*conjuto*/
    private String quadraReal;
    private String loteReal;

    /*shape*/
    private String numeroQuadra;
    private String numeroLote;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToOne
    private CategoriaImovel categoriaImovel;

    @Column(length = 9999)
    private String observacao;

    @ManyToOne
    private Nucleo nucleo;

    /**
     * Dimensões do Imóvel*
     */
    @OneToOne(cascade = CascadeType.ALL)
    private Dimensao dimensao;

    /*coordenada*/
    @OneToMany
    private List<CoordenadaBackup> coordenadasBackup;

    /*Correções*/
    private String loteCorrecao;
    private String quadraCorrecao;
    private String descricaoCorrecao;

    /*Dados do contrato*/
    private String nomeProprietario;
    private String cpfProprietario;
    private String contrato;
    private String status;
    private String matricula;

    @Column(length = 9999)
    private String observacaoProprietario;

    /*Ocupantes*/
    @OneToOne
    private SituacaoProprietario SituacaoOcupante;
    
    // @OneToMany(mappedBy = "imovelBackup", cascade = CascadeType.ALL)
    // private List<ProprietarioBackup> proprietariosBackup;

    /*Edificação do imóvel*/
    @OneToMany
    private List<EdificacaoBackup> edificacaoBuckups;

    /**
     * Coletador*
     */
    @OneToOne
    private Usuario usuarioColetador;

    @OneToOne(cascade = CascadeType.ALL)
    private CoordenadaBackup coordenadaColetaBackup;

    /*anexos*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imovelBackup")
    private List<AnexosBackup> AnexosBackups;

    /*atividade*/
    @OneToMany(cascade = CascadeType.ALL)
    private List<Historico> historico;   
    
    @OneToOne
    private TipoDoImovel TipoDoImovel;
    
    // @JsonIgnore
    // public String getProprietariosNomeFormatado() {
    //     // if (proprietariosBackup == null || proprietariosBackup.isEmpty()) {
    //     //     return "Nenhum proprietário";
    //     // }
    //     // StringBuilder nomes = new StringBuilder();
    //     // for (ProprietarioBackup p : proprietariosBackup) {
    //     //     nomes.append(p.getNomePessoa()).append(", ");
    //     // }
    //     int ultimaVirgula = nomes.lastIndexOf(", ");
    //     if (ultimaVirgula >= 0) {
    //         nomes.delete(ultimaVirgula, ultimaVirgula + 2);
    //     }
    //     return nomes.toString();
    // }
    
     @JsonIgnore
    public String getLoteQuadra() {
        String retorno = "";
        if (Utils.isNotEmpty(this.getQuadraReal())) {
            retorno += "Q-" + this.getQuadraReal();
        } else {
            retorno += "Não possui";
        }
        if (Utils.isNotEmpty(this.getLoteReal())) {
            retorno += "/L-" + this.getLoteReal();
        } else {
            retorno += "/Não possui";
        }
        return retorno;
    }
}