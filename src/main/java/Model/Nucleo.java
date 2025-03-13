package Model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Enum.Patrimonio;
import Enum.Regiao;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Nucleo extends EntidadeGenerica {

    @Id
    @SequenceGenerator(sequenceName = "seq_nucleo", name = "seq_nucleo", allocationSize = 1)
    @GeneratedValue(generator = "seq_nucleo", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Patrimonio tipoPatrimonio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Pessoa requerente;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Anexo> anexos;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "anexosExcluidosNucleo",
            joinColumns = @JoinColumn(name = "nucleo_id"),
            inverseJoinColumns = @JoinColumn(name = "anexo_id")
    )
    private List<Anexo> anexosExcluidos;

    @Enumerated(EnumType.STRING)
    private Regiao regiao;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cidade cidade;

    @ManyToOne(fetch = FetchType.LAZY)
    private Orgao orgao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Status status;

    private String identificador;

    @ManyToOne(fetch = FetchType.LAZY)
    private SituacaoJuridica situacaoJuridica;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Quadra> quadras;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Historico> historicos;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Shape shape;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Shape> historicoShape;

    @JsonIgnore
    private boolean bloquearMatriculados;

    @OneToOne(fetch = FetchType.LAZY)
    private AreaIntervencao AreaIntervencao;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<EdificacaoShape> edificacoes;

    @OneToOne
    @JsonIgnore
    private Coordenada coordenadaCentral;
    
    @OneToOne
    private Interessado interessado;

    @OneToOne(fetch = FetchType.LAZY)
    private MatriculaAnterior matriculaAnterior;

    @OneToOne
    private MatriculaAnterior matricula;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.nome);
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
        final Nucleo other = (Nucleo) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @JsonIgnore
    public boolean isBloquearMatriculados() {
        return bloquearMatriculados;
    }

}
