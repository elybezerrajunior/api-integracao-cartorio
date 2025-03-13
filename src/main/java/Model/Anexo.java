package Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Enum.CaminhoPastaAnexo;
import Enum.TipoAnexo;
import Enum.TipoDocumento;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Anexo extends EntidadeGenerica {

    @Id
    @SequenceGenerator(sequenceName = "seq_anexo", name = "seq_anexo", allocationSize = 1)
    @GeneratedValue(generator = "seq_anexo", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;

    private String tituloAnexo;
    private String url;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipo;

    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private CaminhoPastaAnexo caminho;

    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private TipoAnexo tipoDoDocumento;
    
    // @Transient
    // private UploadedFile arquivo;

    @Transient
    @JsonIgnore
    private String base64;

    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private CaminhoPastaAnexo tipoAnexo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Imovel imovel;

    @ManyToMany(mappedBy = "anexos", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Shape> shapes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Nucleo nucleo;

    public Anexo(Anexo anexo) {
        this.nome = anexo.getNome();
        this.tituloAnexo = anexo.getTituloAnexo();
        this.url = anexo.getUrl();
        this.tipo = anexo.getTipo();
        this.caminho = anexo.getCaminho();
        this.tipoDoDocumento = anexo.getTipoDoDocumento();
        this.base64 = anexo.getBase64();
        this.tipoAnexo = anexo.getTipoAnexo();
        this.imovel = anexo.getImovel();
        this.shapes = anexo.getShapes();
        this.nucleo = anexo.getNucleo();
    }

}
