package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class CategoriaImovel extends EntidadeGenerica {
    
    @Id
    @SequenceGenerator(sequenceName = "seq_categoriaImovel", name = "seq_categoriaImovel", allocationSize = 1)
    @GeneratedValue(generator = "seq_categoriaImovel", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;     
           
}
