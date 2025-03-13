package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class TipoParte extends EntidadeGenerica {

    @Id
    @SequenceGenerator(sequenceName = "seq_tipoParte", name = "seq_tipoParte", allocationSize = 1)
    @GeneratedValue(generator = "seq_tipoParte", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String descricao;
    private boolean usadoNoPoloPassivo;
    private boolean usadoNoPoloAtivo;
    private boolean usadoEmOutrosParticipantes;

    public TipoParte(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public TipoParte() {
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

    public boolean isUsadoNoPoloPassivo() {
        return usadoNoPoloPassivo;
    }

    public void setUsadoNoPoloPassivo(boolean usadoNoPoloPassivo) {
        this.usadoNoPoloPassivo = usadoNoPoloPassivo;
    }

    public boolean isUsadoNoPoloAtivo() {
        return usadoNoPoloAtivo;
    }

    public void setUsadoNoPoloAtivo(boolean usadoNoPoloAtivo) {
        this.usadoNoPoloAtivo = usadoNoPoloAtivo;
    }

    public boolean isUsadoEmOutrosParticipantes() {
        return usadoEmOutrosParticipantes;
    }

    public void setUsadoEmOutrosParticipantes(boolean usadoEmOutrosParticipantes) {
        this.usadoEmOutrosParticipantes = usadoEmOutrosParticipantes;
    }

    @Override
    public String toString() {
        return "TipoParte{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", usadoNoPoloPassivo=" + usadoNoPoloPassivo + ", usadoNoPoloAtivo=" + usadoNoPoloAtivo + ", usadoEmOutrosParticipantes=" + usadoEmOutrosParticipantes + '}';
    }

}

