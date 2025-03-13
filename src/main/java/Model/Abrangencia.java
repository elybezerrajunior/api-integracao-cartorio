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
public class Abrangencia extends EntidadeGenerica {
    
    @Id
    @SequenceGenerator(name = "seq_abrangencia", sequenceName = "seq_abrangencia")
    @GeneratedValue(generator = "seq_abrangencia", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String nome;
    private String descricao;
    private String codigo;

}
