package Model;

import java.math.BigDecimal;
import java.util.List;

import Enum.TipoEdificacao;
import Enum.TipoResidencia;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class EdificacaoBackup extends EntidadeGenerica {

    @Id
    @SequenceGenerator(sequenceName = "seq_edificacaoBackup", name = "seq_edificacaoBackup", allocationSize = 1)
    @GeneratedValue(generator = "seq_edificacaoBackup", strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Shape shape;
    private String descricao;

    @OneToMany
    private List<ComodoBackup> ComodoBackup;

    // private List<ProprietarioBackup> proprietarioBackups;
    
    @Enumerated(EnumType.STRING)
    private TipoResidencia tipoResidencia;
    
    @Column(scale = 2, precision = 10)
    @Digits(fraction = 2, integer = 10)
    private BigDecimal areaConstruida;
    
    @Enumerated(EnumType.STRING)
    private TipoEdificacao tipoEdificacao;
    
    @Digits(fraction = 2, integer = 10)
    private BigDecimal fracaoIdeal;
    private String padraoHabitacional;
    
    @Digits(fraction = 2, integer = 10)
    private BigDecimal areaBloco;
    @Digits(fraction = 2, integer = 10)
    private BigDecimal areaTotalEdificadaBloco;
    @Digits(fraction = 2, integer = 10)
    private BigDecimal taxaAreaImovel;
    private String bloco;
    
}
