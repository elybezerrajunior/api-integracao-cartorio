package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class TipoDoImovel extends EntidadeGenerica {
    @Id
    @SequenceGenerator(sequenceName = "seq_tipoDoimovel", name = "seq_tipoDoimovel", allocationSize = 1)
    @GeneratedValue(generator = "seq_tipoDoimovel", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
}
