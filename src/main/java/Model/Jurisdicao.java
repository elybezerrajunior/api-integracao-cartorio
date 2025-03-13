package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Jurisdicao extends EntidadeGenerica {
    
    @Id
    @SequenceGenerator(sequenceName = "seq_jurisdicao", name = "seq_jurisdicao", allocationSize = 1)
    @GeneratedValue(generator = "seq_jurisdicao", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String descricao;
    @OneToOne
    private Materia materia;

    public Jurisdicao() {
    }

    public Jurisdicao(Long id, String nome, String descricao, Materia materia) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.materia = materia;
    }

}
