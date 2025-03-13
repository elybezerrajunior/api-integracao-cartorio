package Model;

import java.math.BigDecimal;

import io.jsonwebtoken.lang.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Dimensao extends EntidadeGenerica {

    @Id
    @SequenceGenerator(sequenceName = "seq_dimensao", name = "seq_dimensao", allocationSize = 1)
    @GeneratedValue(generator = "seq_dimensao", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(scale = 2, precision = 10)
    @Digits(fraction = 2, integer = 10)
    private BigDecimal areaTerreno;

    @Column(scale = 2, precision = 10)
    @Digits(fraction = 2, integer = 10)
    private BigDecimal areaTotalEdificacao;

    @Column(scale = 2, precision = 10)
    @Digits(fraction = 2, integer = 10)
    private BigDecimal perimetro;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

}

