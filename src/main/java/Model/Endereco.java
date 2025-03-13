package Model;

import Enum.TipoLogradouro;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Endereco extends EntidadeGenerica{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;
    private String cep;
    private String numero;
    @Column(length = 9999)
    private String complemento;
    private String nomeDoConjunto;
    private String quadra;
    private String lote;
    @OneToOne
    private Bairro bairro;
    @Enumerated(EnumType.STRING)
    private TipoLogradouro tipoLogradouro;

    public Endereco(){
    }
}
