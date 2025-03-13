package Model;

import java.util.List;

import Enum.StatusLote;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Lote extends EntidadeGenerica {

    @Id
    @SequenceGenerator(sequenceName = "seq_lote", name = "seq_lote", allocationSize = 1)
    @GeneratedValue(generator = "seq_lote", strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long identificador;
    private String numero;
    private String loteLetra;
    private String numeroQuadra;

    @ManyToOne(fetch = FetchType.EAGER)
    private Quadra quadra;

    @OneToOne(cascade = CascadeType.ALL)
    private Shape shape;

    @OneToOne
    private Bairro bairro;

    private Boolean geradoRemessa;

    private Long identificadorlote;

    @Enumerated(EnumType.STRING)
    private StatusLote statusLote;

    @OneToMany
    private List<Confrontante> confrontantes;

    @OneToOne
    private Imovel imovel;
    @OneToMany(cascade = CascadeType.ALL)
    private List<EdificacaoShape> edificacoes;
    private String quadraLote;

    private String identificadorEstado;
    
    @Transient
    private Long nucleoId;
    
}
