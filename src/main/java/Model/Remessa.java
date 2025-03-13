package Model;

import java.util.ArrayList;
import java.util.List;

import Enum.SituacaoRemessa;
import Enum.TipoRemessa;
import Util.Utils;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Remessa extends EntidadeGenerica {
    
    @Id
    @SequenceGenerator(sequenceName = "seq_remessa", name = "seq_remessa", allocationSize = 1)
    @GeneratedValue(generator = "seq_remessa", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Nucleo nucleo;

    @Enumerated(EnumType.STRING)
    private SituacaoRemessa situacaoRemessa;

    @Enumerated(EnumType.STRING)
    private TipoRemessa tipoRemessa;

    @ManyToOne
    @JoinColumn(name = "cartorio_id", referencedColumnName = "id")
    private Orgao cartorio;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Parcela> parcelas;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "parcelasDoNucleo")
    private List<Parcela> parcelasDoNucleo;

    @OneToMany
    private List<NotaDevolucao> notasDevolucoes;

    @ManyToOne
    @JoinColumn(name = "proprietarioatual_id", referencedColumnName = "id")
    private Orgao proprietarioAtual;

    @ManyToOne
    private Orgao requerente;

    public Remessa() {}

    public Remessa(Nucleo nucleo, Orgao cartorio, List<ServicoCartorio> servicos, List<Imovel> imoveis, List<Parcela> parcelas, List<Parcela> parcelasDoNucleo, TipoRemessa tipoRemessa) {
        this.nucleo = nucleo;
        this.cartorio = cartorio;
        this.parcelas = parcelas;
        this.parcelasDoNucleo = parcelasDoNucleo;
        this.tipoRemessa = tipoRemessa;
        this.situacaoRemessa = SituacaoRemessa.GERADO;
        if (Utils.isNotEmpty(nucleo)) {
            if (Utils.isNotEmpty(nucleo.getOrgao())) {
                this.proprietarioAtual = nucleo.getOrgao();
                this.requerente = nucleo.getOrgao();
            }
        }
    }

}
