package Model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Bairro extends EntidadeGenerica{

    @Id
    @SequenceGenerator(sequenceName = "seq_bairro", name = "seq_bairro", allocationSize = 50000)
    @GeneratedValue(generator = "seq_bairro", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    @OneToOne
    private Cidade cidade;
    private boolean ativo;

    public Bairro() {
        this.ativo = true;
    }

}
