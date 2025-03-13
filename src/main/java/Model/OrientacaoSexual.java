package Model;

import io.jsonwebtoken.lang.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode
public class OrientacaoSexual extends EntidadeGenerica {

    @Id
    @SequenceGenerator(sequenceName = "seq_orientacaoSexual", name = "seq_orientacaoSexual", allocationSize = 1)
    @GeneratedValue(generator="seq_orientacaoSexual",strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String descricao;

    public OrientacaoSexual() {
    }

    public OrientacaoSexual(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "OrientacaoSexual{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + '}';
    }
    
    
}

