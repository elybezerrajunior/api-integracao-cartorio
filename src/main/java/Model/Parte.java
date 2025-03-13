package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode
public class Parte extends EntidadeGenerica {

    @Id
    @SequenceGenerator(sequenceName = "seq_parte", name = "seq_parte", allocationSize = 1)
    @GeneratedValue(generator = "seq_parte", strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    private TipoParte tipoParte;
    @OneToOne
    private Proprietario legitimado;
    private boolean parteSigilosa;

    public Parte() {
    }

    public Parte(Long id, TipoParte tipoParte, Proprietario legitimado, boolean parteSigilosa) {
        this.id = id;
        this.tipoParte = tipoParte;
        this.legitimado = legitimado;
        this.parteSigilosa = parteSigilosa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoParte getTipoParte() {
        return tipoParte;
    }

    public void setTipoParte(TipoParte tipoParte) {
        this.tipoParte = tipoParte;
    }

    public Proprietario getLegitimado() {
        return legitimado;
    }

    public void setLegitimado(Proprietario legitimado) {
        this.legitimado = legitimado;
    }

    public boolean isParteSigilosa() {
        return parteSigilosa;
    }

    public void setParteSigilosa(boolean parteSigilosa) {
        this.parteSigilosa = parteSigilosa;
    }

    @Override
    public String toString() {
        return "Parte{" + "id=" + id + ", tipoParte=" + tipoParte + ", legitimado=" + legitimado + ", parteSigilosa=" + parteSigilosa + '}';
    }

}