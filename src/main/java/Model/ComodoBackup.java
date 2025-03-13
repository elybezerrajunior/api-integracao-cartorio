package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ComodoBackup extends EntidadeGenerica {
    @Id
    @SequenceGenerator(sequenceName = "seq_comodoBackup", name = "seq_comodoBackup", allocationSize = 1)
    @GeneratedValue(generator = "seq_comodoBackup", strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    private TipoComodo tipoComodo;
    private int quantidade;
    
}
