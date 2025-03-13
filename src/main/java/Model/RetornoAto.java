package Model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode
public class RetornoAto extends EntidadeGenerica {

    @Id
    @SequenceGenerator(sequenceName = "seq_retornoAto", name = "seq_retornoAto", allocationSize = 1)
    @GeneratedValue(generator = "seq_retornoAto", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String numero;
    private String status;
    @OneToOne
    private MatriculaAnterior matricula;
    private String numeroAto;
    private Date dataAto;
    private String numeroProtocolo;
    private Date dataProtocolo;
    private String teor;
    private String pdfCartorio;
    private List<String> selos;
    @OneToOne
    private Servico servicoCartorio;
    private String remessa;
    private String numeroParcela;

    public RetornoAto() {
    }

    public RetornoAto(String numero, String status, MatriculaAnterior matricula, String numeroAto, Date dataAto, String numeroProtocolo, Date dataProtocolo, String teor, String pdfCartorio, List<String> selos, Servico servicoCartorio, String remessa, String numeroParcela) {
        this.numero = numero;
        this.status = status;
        this.matricula = matricula;
        this.numeroAto = numeroAto;
        this.dataAto = dataAto;
        this.numeroProtocolo = numeroProtocolo;
        this.dataProtocolo = dataProtocolo;
        this.teor = teor;
        this.pdfCartorio = pdfCartorio;
        this.selos = selos;
        this.servicoCartorio = servicoCartorio;
        this.remessa = remessa;
        this.numeroParcela = numeroParcela;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Servico getServicoCartorio() {
        return servicoCartorio;
    }

    public void setServicoCartorio(Servico servicoCartorio) {
        this.servicoCartorio = servicoCartorio;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MatriculaAnterior getMatricula() {
        return matricula;
    }

    public void setMatricula(MatriculaAnterior matricula) {
        this.matricula = matricula;
    }

    public String getNumeroAto() {
        return numeroAto;
    }

    public void setNumeroAto(String numeroAto) {
        this.numeroAto = numeroAto;
    }

    public Date getDataAto() {
        return dataAto;
    }

    public void setDataAto(Date dataAto) {
        this.dataAto = dataAto;
    }

    public String getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo(String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public Date getDataProtocolo() {
        return dataProtocolo;
    }

    public void setDataProtocolo(Date dataProtocolo) {
        this.dataProtocolo = dataProtocolo;
    }

    public String getTeor() {
        return teor;
    }

    public void setTeor(String teor) {
        this.teor = teor;
    }

    public String getPdfCartorio() {
        return pdfCartorio;
    }

    public void setPdfCartorio(String pdfCartorio) {
        this.pdfCartorio = pdfCartorio;
    }

    public List<String> getSelos() {
        return selos;
    }

    public void setSelos(List<String> selos) {
        this.selos = selos;
    }

    public String getRemessa() {
        return remessa;
    }

    public void setRemessa(String remessa) {
        this.remessa = remessa;
    }

    public String getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(String numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    @Override
    public String toString() {
        return "RetornoAto{" + "numero=" + numero + ", status=" + status + ", matricula=" + matricula + ", numeroAto=" + numeroAto + ", dataAto=" + dataAto + ", numeroProtocolo=" + numeroProtocolo + ", dataProtocolo=" + dataProtocolo + ", teor=" + teor + ", pdfCartorio=" + pdfCartorio + ", selos=" + selos + ", servicoCartorio=" + servicoCartorio + ", remessa=" + remessa + ", numeroParcela=" + numeroParcela + '}';
    }

}
