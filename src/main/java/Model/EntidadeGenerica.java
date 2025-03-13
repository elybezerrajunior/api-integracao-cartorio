package Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;

@MappedSuperclass
public class EntidadeGenerica implements Serializable {

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private Boolean ativo;

    @OneToOne
    @JsonIgnore
    private Credenciada credenciada;
    
    @Version
    private int version;

    public EntidadeGenerica() {
        this.ativo = true;
        this.dataCriacao = LocalDateTime.now();
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Credenciada getCredenciada() {
        return credenciada;
    }

    public void setCredenciada(Credenciada credenciada) {
        this.credenciada = credenciada;
    }

}
