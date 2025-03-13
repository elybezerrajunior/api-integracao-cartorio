package Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Confrontante extends EntidadeGenerica {
    @Id
    @SequenceGenerator(sequenceName = "seq_confrontante", name = "seq_confrontante", allocationSize = 1)
    @GeneratedValue(generator = "seq_confrontante", strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    private Pessoa conjuge;
    @OneToMany
    private List<Anexo> comprovantesPosse;
    @OneToOne
    private Lote lote;
}
