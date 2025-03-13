package Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Comodo extends EntidadeGenerica {
    
    @Id
    @SequenceGenerator(sequenceName = "seq_comodo", name = "seq_comodo", allocationSize = 1)
    @GeneratedValue(generator = "seq_comodo", strategy = GenerationType.SEQUENCE)    
    private Long id;
        
    @ManyToOne(fetch = FetchType.LAZY) 
    private TipoComodo tipoComodo;

    @JsonIgnore
    private Integer quantidade;
    
}