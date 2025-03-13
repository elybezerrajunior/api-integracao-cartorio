package Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Materia extends EntidadeGenerica {
    
    @Id
    @SequenceGenerator(sequenceName = "seq_materia", name = "seq_materia", allocationSize = 1)
    @GeneratedValue(generator = "seq_materia", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String descricao;
    @OneToMany
    private List<Jurisdicao> juridiscoes;

    public Materia() {
    }

    public Materia(Long id, String nome, String descricao, List<Jurisdicao> juridiscoes) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.juridiscoes = juridiscoes;
    }

}
