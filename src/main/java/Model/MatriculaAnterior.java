package Model;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class MatriculaAnterior extends EntidadeGenerica {
    
    @Id
    @SequenceGenerator(sequenceName = "seq_matricula_anterior", name = "seq_matricula_anterior", allocationSize = 1)
    @GeneratedValue(generator = "seq_matricula_anterior", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "numeroMatricula")
    private String numero_matricula;    
    
    private String livro;
    
    private String complemento_matricula;
    
    private String cns;
    
    private String descricao;

    private String folha;
    
    @Temporal(TemporalType.DATE)
    private Date data_matricula;
    
    @OneToOne
    private Orgao orgao;

    public MatriculaAnterior(MatriculaAnterior m) {
        this.numero_matricula = m.getNumero_matricula();
        this.livro = m.getLivro();
        this.complemento_matricula = m.getComplemento_matricula();
        this.cns = m.getCns();
        this.descricao = m.getDescricao();
        this.folha = m.getFolha();
    }

}
