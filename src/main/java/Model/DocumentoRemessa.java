package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class DocumentoRemessa extends EntidadeGenerica {

    @Id
    @SequenceGenerator(sequenceName = "seq_documentoRemessa", name = "seq_documentoRemessa", allocationSize = 1)
    @GeneratedValue(generator = "seq_documentoRemessa", strategy = GenerationType.SEQUENCE)

    private Long id;
    private String nome;
    private String arquivo;
    private String tipo;

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

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "DocumentoRemessa{" + "nome=" + nome + ", arquivo=" + arquivo + ", tipo=" + tipo + '}';
    }

}

