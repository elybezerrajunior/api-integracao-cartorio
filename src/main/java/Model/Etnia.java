package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Etnia extends EntidadeGenerica {
    
    @Id
    @SequenceGenerator(sequenceName = "seq_etnia", name = "seq_etnia", allocationSize = 1)
    @GeneratedValue(generator = "seq_etnia", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String descricao;

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
        return "Etnia{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + '}';
    }
    
}
