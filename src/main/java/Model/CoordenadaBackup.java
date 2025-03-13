package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class CoordenadaBackup extends EntidadeGenerica {
    
    @Id
    @SequenceGenerator(sequenceName = "seq_coordenadaBackup", name = "seq_coordenadaBackup", allocationSize = 1)
    @GeneratedValue(generator = "seq_coordenadaBackup", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column
    private Double latitude;
    @Column
    private Double longitude;
    
    private String zona;
    
}
