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
public class SituacaoProprietario extends EntidadeGenerica {
    
    @Id
    @SequenceGenerator(sequenceName = "seq_situacaoOcupante", name = "seq_situacaoOcupante", allocationSize = 1)
    @GeneratedValue(generator = "seq_situacaoOcupante", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String descricao;

}
