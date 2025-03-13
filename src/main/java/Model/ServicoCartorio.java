package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class ServicoCartorio extends EntidadeGenerica {

    @Id
    @SequenceGenerator(sequenceName = "seq_servicoCartorio", name = "seq_servicoCartorio", allocationSize = 1)
    @GeneratedValue(generator = "seq_servicoCartorio", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String codigo;
    private String descricao;

    public ServicoCartorio() {
    }

    public ServicoCartorio(Long id, String nome, String codigo, String descricao) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
    }
}

