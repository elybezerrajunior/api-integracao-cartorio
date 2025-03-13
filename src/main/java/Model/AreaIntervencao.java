package Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
public class AreaIntervencao extends EntidadeGenerica {

    @Id
    @SequenceGenerator(sequenceName = "seq_areaIntervencao", name = "seq_areaIntervencao", allocationSize = 1)
    @GeneratedValue(generator = "seq_areaIntervencao", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String descricao;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Orgao orgao;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Nucleo> nucleos;

    @JsonIgnore
    private Boolean sentenciado;

    @JsonIgnore
    private String identificador;
    
}
