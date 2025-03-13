package Model;

import java.sql.Date;
import java.util.List;

import Enum.TipoProcesso;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Processo extends EntidadeGenerica {
    
    @Id
    @SequenceGenerator(name = "seq_processo", sequenceName = "seq_processo")
    @GeneratedValue(generator = "seq_processo", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoProcesso tipoProcesso;
    @OneToOne
    private Materia materia;
    @OneToOne
    private Jurisdicao jurisdicao;
    @OneToOne
    private ClasseJudicial classeJudicial;
    private Date dataProcesso;
    @OneToOne
    private Modalidade modalidade;
    private String numeroProcesso;
    @OneToMany
    private List<Advogado> advogados;
    @OneToOne
    private Imovel imovel;
    @OneToOne
    private Nucleo nucleo;
    @OneToOne
    private MatriculaAnterior matriculaAnterior;
    @OneToMany
    private List<ProprietarioAtual> proprietariosAtuais;
    @OneToMany
    private List<Anexo> anexos;
    private boolean possuiMatriculaAnterior;
    private boolean possuiProprietarioAtual;
    @OneToMany
    private List<Servico> servicos;

    @OneToOne
    private Orgao orgao;

}
