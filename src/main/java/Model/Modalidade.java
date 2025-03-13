package Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Modalidade extends EntidadeGenerica {
    
    @Id
    @SequenceGenerator(name = "seq_modalidade", sequenceName = "seq_modalidade")
    @GeneratedValue(generator = "seq_modalidade", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String nome;
    private String fundamento;
    private String prazo;
    @OneToMany
    private List<Requisito> requisitos;
    @OneToMany
    private List<Abrangencia> abrangencia;

}
