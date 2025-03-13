package Model;

import Enum.TipoCoordenada;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Coordenada extends EntidadeGenerica {
    
    @Id
    @SequenceGenerator(sequenceName = "seq_coordenada", name = "seq_coordenada", allocationSize = 1)
    @GeneratedValue(generator = "seq_coordenada", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private Double latitude;
    @Column
    private Double longitude;
    private String zona;
    private String latitudeconvertida;
    private String longitudeconvertida;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_coordenada")
    private TipoCoordenada tipoCoordenada;

    private String nome;

}
