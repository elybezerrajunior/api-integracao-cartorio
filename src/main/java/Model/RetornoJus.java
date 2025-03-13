package Model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class RetornoJus extends EntidadeGenerica {

    @Id
    @SequenceGenerator(sequenceName = "seq_retornoJus", name = "seq_retornoJus", allocationSize = 1)
    @GeneratedValue(generator = "seq_retornoJus", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String status;
    @OneToOne
    private MatriculaAnterior matricula;
    private String numeroAto;
    @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date dataAto;
    private String numeroProtocolo;
    @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date dataProtocolo;
    @Column(length = 10000)
    private String teor;
    // private List<String> selos;
    @OneToOne
    private ServicoCartorio servicoCartorio;
    private Long remessa;
    private Long numeroParcela;
    @OneToOne
    private Orgao cartorio;

    public RetornoJus() {
    }

    public RetornoJus(Long id, String status, MatriculaAnterior matricula, String numeroAto, Date dataAto, String numeroProtocolo, Date dataProtocolo, String teor, List<String> selos, ServicoCartorio servicoCartorio, Long remessa, Long numeroParcela, Orgao cartorio) {
        this.id = id;
        this.status = status;
        this.matricula = matricula;
        this.numeroAto = numeroAto;
        this.dataAto = dataAto;
        this.numeroProtocolo = numeroProtocolo;
        this.dataProtocolo = dataProtocolo;
        this.teor = teor;
        // this.selos = selos;
        this.servicoCartorio = servicoCartorio;
        this.remessa = remessa;
        this.numeroParcela = numeroParcela;
        this.cartorio = cartorio;
    }

}
