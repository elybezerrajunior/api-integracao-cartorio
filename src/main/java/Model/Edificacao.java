package Model;

import java.math.BigDecimal;
import java.util.List;

import Enum.TipoEdificacao;
import Enum.TipoResidencia;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Edificacao {

    @Id
    @SequenceGenerator(sequenceName = "seq_edificacao", name = "seq_edificacao", allocationSize = 1)
    @GeneratedValue(generator = "seq_edificacao", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(scale = 2, precision = 10)
    @Digits(fraction = 2, integer = 10)
    private BigDecimal areaConstruida;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Comodo> comodos;

    @Enumerated(EnumType.STRING)
    private TipoEdificacao tipoEdificacao;

    @Enumerated(EnumType.STRING)
    private TipoResidencia tipoResidencia;

    private String frenteBloco;
    private String fundoBloco;
    private String ladoEsquerdoBloco;
    private String ladoDireitoBloco;

    private String frenteQuadra;
    private String fundoQuadra;
    private String ladoEsquerdoQuadra;
    private String ladoDireitoQuadra;

    private String numeroQuadra;
    @Digits(fraction = 2, integer = 10)
    private BigDecimal areaQuadra;
    @Digits(fraction = 2, integer = 10)
    private BigDecimal taxaAreaQuadra;
    @Digits(fraction = 2, integer = 10)
    private BigDecimal taxaOcupacaoQuadra;

    @Digits(fraction = 2, integer = 10)
    private BigDecimal areaBloco;
    @Digits(fraction = 2, integer = 10)
    private BigDecimal areaTotalEdificadaBloco;
    @Digits(fraction = 2, integer = 10)
    private BigDecimal taxaOcupacaoDoBloco;

    @Digits(fraction = 2, integer = 10)
    private BigDecimal fracaoIdeal;
    private String identificacao;

    private String bloco;
    private String padraoHabitacional;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "edificacao_proprietario",
        joinColumns = @JoinColumn(name = "edificacoes_id"),
        inverseJoinColumns = @JoinColumn(name = "proprietarios_id")
    )
    private List<Proprietario> proprietarios;

}