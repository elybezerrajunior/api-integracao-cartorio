package Model;

import java.sql.Date;
import java.util.List;

import Util.DateUtils;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode
@Setter
@Getter
public class NotaDevolucao extends EntidadeGenerica {

    @Id
    @SequenceGenerator(name = "seq_notaDevolucao", sequenceName = "seq_notaDevolucao")
    @GeneratedValue(generator = "seq_notaDevolucao", strategy = GenerationType.SEQUENCE)
    private Long id;
    private Date dataNota;
    private String conteudo;
    private String statusNota;
    private String numeroProtocolo;
    private List<String> servicos;
    @OneToOne
    private Remessa remessa;
    @ManyToMany
    private List<Anexo> anexos; 

    public NotaDevolucao() {
    }

    public NotaDevolucao(Long id, Date dataNota, String conteudo, String statusNota, String numeroProtocolo, List<String> servicos, Remessa remessa) {
        this.id = id;
        this.dataNota = dataNota;
        this.conteudo = conteudo;
        this.statusNota = statusNota;
        this.numeroProtocolo = numeroProtocolo;
        this.servicos = servicos;
        this.remessa = remessa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataNota() {
        return dataNota;
    }

    public List<Anexo> getAnexos() {
        return anexos;
    }

    public void setAnexos(List<Anexo> anexos) {
        this.anexos = anexos;
    }

    public String getDataFormatada() {
        return DateUtils.format(DateUtils.DD_MM_YYYY, dataNota);
    }

    public void setDataNota(Date dataNota) {
        this.dataNota = dataNota;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getStatusNota() {
        return statusNota;
    }

    public void setStatusNota(String statusNota) {
        this.statusNota = statusNota;
    }

    public List<String> getServicos() {
        return servicos;
    }

    public void setServicos(List<String> servicos) {
        this.servicos = servicos;
    }

    public Remessa getRemessa() {
        return remessa;
    }

    public void setRemessa(Remessa remessa) {
        this.remessa = remessa;
    }

    public String getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo(String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    @Override
    public String toString() {
        return "NotaDevolucao{" + "id=" + id + ", dataNota=" + dataNota + ", conteudo=" + conteudo + ", statusNota=" + statusNota + ", servicos=" + servicos + '}';
    }

}

