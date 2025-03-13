package Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class EdificacaoShape extends EntidadeGenerica {
    
    @Id
    @SequenceGenerator(sequenceName = "seq_edificacaoShape", name = "seq_edificacaoShape", allocationSize = 1)
    @GeneratedValue(generator = "seq_edificacaoShape", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Shape shape;
    
    private String descricao;
    
    public EdificacaoShape(Shape shape) {
        this.shape = shape;
    }
}
