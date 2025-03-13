package Model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Enum.StatusImovel;
import Enum.StatusLote;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Imovel extends EntidadeGenerica {
    
    @Id
    @SequenceGenerator(sequenceName = "seq_imovel", name = "seq_imovel", allocationSize = 1)
    @GeneratedValue(generator = "seq_imovel", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String quadraShape;

    private String loteShape;

    private String loteLetraShape;

    private String loteColeta;

    private String quadraColeta;

    private String loteLetraColeta;

    @JsonIgnore
    private boolean casaFechadaOuRecusada;

    @OneToOne
    private MatriculaAnterior matricula;

    @OneToOne
    private MatriculaAnterior matriculaAnterior;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Endereco enderecoImovel;

    @ManyToOne(fetch = FetchType.LAZY)
    private TipoDoImovel tipoDoImovel;

    @Column(length = 9999)
    private String observacao;

    private String frente;
    private String fundo;
    private String ladoEsquerdo;
    private String ladoDireito;

    @JsonIgnore
    @OneToOne
    private Coordenada coordenadaColeta;

    @ManyToOne(fetch = FetchType.LAZY)
    private SituacaoProprietario situacaoProprietario;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Proprietario> proprietarios;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Dimensao dimensao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Nucleo nucleo;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Edificacao> edificacoes;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Usuario usuarioColetador;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Usuario analista;

    @OneToMany
    @JsonIgnore
    private List<Anexo> anexos;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "anexosExcluidos",
            joinColumns = @JoinColumn(name = "imovel_id"),
            inverseJoinColumns = @JoinColumn(name = "anexo_id")
    )
    private List<Anexo> anexosExcluidos;

    @JsonIgnore
    private Date dataColeta;

    @JsonIgnore
    private Date dataAnalise;

    private boolean alterarStatusJus;
    private boolean migradoAoJus;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Historico> historicos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Status statusAtual;

    private String loteCorrecao;
    private String quadraCorrecao;
    private String descricaoCorrecao;

    @Enumerated(EnumType.STRING)
    private StatusLote statusLote;

    @JsonIgnore
    private Boolean sobAnalise;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ImovelBackup> imoveisBackup;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private ImovelBackup imovelBackup;

    private boolean aberturaMatricula;

    @Enumerated(EnumType.STRING)
    private StatusImovel situacaoImovel;

    @OneToMany
    private List<RetornoJus> retornoJus;

    @OneToMany(fetch = FetchType.LAZY)
    List<Coordenada> coordenadasImovel;

    private String numeroProcessoAdministrativo;

    @Column(length = 9999)
    private String observacaoAnalise;

}
