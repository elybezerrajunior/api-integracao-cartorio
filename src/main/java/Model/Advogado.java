package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Advogado extends EntidadeGenerica {
    
    @Id
    @SequenceGenerator(sequenceName = "seq_advogado", name = "seq_advogado", allocationSize = 1)
    @GeneratedValue(generator = "seq_advogado", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String oab;
    private String cpf;
    private String tipoRepresentante;
    @OneToOne
    private Endereco endereco;

    public Advogado() {
    }

    public Advogado(Long id, String nome, String oab, String cpf, String tipoRepresentante, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.oab = oab;
        this.cpf = cpf;
        this.tipoRepresentante = tipoRepresentante;
        this.endereco = endereco;
    }

}
