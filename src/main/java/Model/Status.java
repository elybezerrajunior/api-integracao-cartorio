package Model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.jsonwebtoken.lang.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
public class Status extends EntidadeGenerica {

    @Id
    @SequenceGenerator(sequenceName = "seq_status", name = "seq_status", allocationSize = 1)
    @GeneratedValue(generator = "seq_status", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private Long posicao;

    @Column(scale = 2, precision = 10)
    @Digits(fraction = 2, integer = 10)
    private BigDecimal pontuacaoDaAtividade;

    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria;
    
    private String descricao;
    
    private String cor;
    private String corMapa;
    private String legenda;

    @OneToMany(mappedBy = "statusAtual", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Imovel> imoveis;

    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Historico> historicos;

    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Nucleo> nucleos;
}
