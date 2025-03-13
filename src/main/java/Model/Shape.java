package Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import Enum.TipoShape;
import Util.Utils;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Shape extends EntidadeGenerica {

    @Id
    @SequenceGenerator(sequenceName = "seq_shape", name = "seq_shape", allocationSize = 1)
    @GeneratedValue(generator = "seq_shape", strategy = GenerationType.SEQUENCE)
    private Long id;
    private boolean ativo;

    @Column(scale = 2, precision = 10)
    private BigDecimal area;

    @Column(scale = 2, precision = 10)
    private BigDecimal perimetro;

    private String cidade;
    private String lote;
    private String loteLetra;
    private String quadra;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Coordenada> coordenadas;
    @Enumerated(EnumType.STRING)
    private TipoShape tipoShape;
    private String zona;

    private String frente;
    private String fundo;
    private String direita;
    private String esquerda;

//    Dados do contrator
    private String nomeProprietario;
    private String cpfProprietario;
    private boolean possuiProprietario;
    private String contrato;
    private String status;
    private String matricula;

    @Column(length = 9999)
    private String observacao;
    private String bloqueio;
    
    private String valorTotalAtraso;
    private String valorTotalDiferenca;
    private String saldoDevedor;
    private String qtdPrestacoesAtraso;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Anexo> anexos;

    public Shape() {
        this.ativo = true;
    }

    public String getCoordenadasToNotario() {

        List<String> coordenadasAsString = new ArrayList<>();

        if (Utils.isNotEmpty(coordenadas)) {
            for (Coordenada c : this.coordenadas) {
                String coordenadaAsString = String.format("%s %s", c.getLongitude(), c.getLatitude());
                coordenadasAsString.add(coordenadaAsString);
            }
        }

        if (Utils.isNotEmpty(coordenadasAsString)) {
            return String.join(", ", coordenadasAsString);
        }

        return "";

    }

}

