package Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Quadra extends EntidadeGenerica {
        
    @Id
    @SequenceGenerator(sequenceName = "seq_quadra", name = "seq_quadra", allocationSize = 1)
    @GeneratedValue(generator = "seq_quadra", strategy = GenerationType.SEQUENCE)
    private Long id;
            
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Lote> lotes;
    
    private String numero;
    
    private String quadraLetra;
    
    @OneToOne
    private Shape shape;

}
