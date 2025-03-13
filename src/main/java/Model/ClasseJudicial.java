package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ClasseJudicial extends EntidadeGenerica {
    
    @Id
    @SequenceGenerator(sequenceName = "seq_classeJudicial", name = "seq_classeJudicial", allocationSize = 1)
    @GeneratedValue(generator = "seq_classeJudicial", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String descricao;
    private boolean exigePoloPassivo;
    @OneToOne
    private Jurisdicao jurisdicao;

    public ClasseJudicial() {
    }

    public ClasseJudicial(Long id, String nome, String descricao, boolean exigePoloPassivo, Jurisdicao jurisdicao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.exigePoloPassivo = exigePoloPassivo;
        this.jurisdicao = jurisdicao;
    }

}
