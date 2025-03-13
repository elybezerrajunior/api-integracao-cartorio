package Model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Enum.CaminhoPastaAnexo;
import Enum.TipoAnexo;
import Util.Caracteres;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AnexosBackup extends EntidadeGenerica {

    @Id
    @SequenceGenerator(sequenceName = "seq_anexosBackup", name = "seq_anexosBackup", allocationSize = 1)
    @GeneratedValue(generator = "seq_anexosBackup", strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String nomeExibicao;
    private String url;


    @Enumerated(EnumType.STRING)
    private TipoAnexo caminho;

    // @Transient
    // private UploadedFile arquivo;

    @Transient
    private Date dataArquivo;

    @Transient
    private String base64;

    @Enumerated(EnumType.STRING)
    private TipoAnexo tipo;

    @ManyToOne
    private ImovelBackup imovelBackup;
    
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private CaminhoPastaAnexo tipoAnexo;

    public String getNomeExibicao() {
        return Caracteres.formatarNomeExibicao(nomeExibicao);
    }   
        

}
