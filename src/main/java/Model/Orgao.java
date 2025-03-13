package Model;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Enum.TipoDocumento;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Orgao extends EntidadeGenerica {

    @Id
    @SequenceGenerator(sequenceName = "seq_orgao", name = "seq_orgao", allocationSize = 1)
    @GeneratedValue(generator = "seq_orgao", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;

    private String razaoSocial;

    private String telefone;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Endereco enderecoDoOrgao;

    @ManyToOne(fetch = FetchType.LAZY)
    private TipoOrgao tipoDeOrgao;

    @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date dataNascimento;

    // @CNPJ
    private String cnpj;

    // @CPF
    private String cpf;

    // @Email
    private String email;

    @OneToMany(mappedBy = "orgao", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Usuario> usuarios;

    private String codigoIBGEServentia;
    private String codigoServentia;
    private String oficioServentia;
    private String nomeTabeliao;

    private String nomePrefeito;

    private String nomeResponsavel;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Orgao other = (Orgao) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

}
