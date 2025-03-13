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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class SituacaoJuridica extends EntidadeGenerica {
    
    @Id
    @SequenceGenerator(name = "seq_situacaoJuridica", sequenceName = "seq_situacaoJuridica", initialValue = 1)
    @GeneratedValue(generator = "seq_situacaoJuridica", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String nome;
    
    private String descricao;
    
}
