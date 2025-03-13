package Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Enum.StatusParcela;
import Util.Utils;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Parcela extends EntidadeGenerica {

    @Id
    @SequenceGenerator(sequenceName = "seq_parcela", name = "seq_parcela", allocationSize = 1)
    @GeneratedValue(generator = "seq_parcela", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Imovel imovel;

    @ManyToOne
    private Nucleo nucleo;

    @ManyToOne(cascade = CascadeType.ALL)
    private MatriculaAnterior matricula;

    private String textoMemorial;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private MatriculaAnterior matriculaAnterior;

    @ManyToMany
    private List<ServicoCartorio> servicos;

    private String numeroLote;

    private String numeroQuadra;

    @Enumerated(EnumType.STRING)
    private StatusParcela status; 

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProprietarioAtual> proprietariosAtuais;
    private String areaInterese;

    @OneToMany
    private List<RetornoAto> retornoAto;

    public Parcela(Nucleo nucleo, List<ServicoCartorio> servicos, Imovel imovel) {
        this.servicos = servicos;
        this.imovel = imovel;
        this.nucleo = nucleo;

        if (Utils.isNotEmpty(imovel)) {
            this.numeroLote = imovel.getLoteShape();
            this.numeroQuadra = imovel.getQuadraShape();

            if (Utils.isNotEmpty(imovel.getProprietarios())) {
                proprietariosAtuais = new ArrayList<>();
                imovel.getProprietarios().forEach(p -> proprietariosAtuais.add(new ProprietarioAtual(p)));
            }

            if (Utils.isNotEmpty(imovel.getMatriculaAnterior())) {
                this.matriculaAnterior = new MatriculaAnterior(imovel.getMatriculaAnterior());
            }

            if (Utils.isNotEmpty(imovel.getMatricula())) {
                this.matricula = new MatriculaAnterior(imovel.getMatricula());
            }
        } else {
            if (Utils.isNotEmpty(nucleo)) {
                if (Utils.isNotEmpty(nucleo.getMatriculaAnterior())) {
                    this.matriculaAnterior = new MatriculaAnterior(nucleo.getMatriculaAnterior());
                }

                if (Utils.isNotEmpty(nucleo.getMatricula())) {
                    this.matricula = new MatriculaAnterior(nucleo.getMatricula());
                }

                if (Utils.isNotEmpty(nucleo.getOrgao())) {
                    proprietariosAtuais = new ArrayList<>();
                    proprietariosAtuais.add(new ProprietarioAtual(nucleo.getOrgao()));
                }
            }
        }

        if (Utils.isNotEmpty(nucleo)) {
            if (Utils.isNotEmpty(nucleo.getAreaIntervencao())) {
                this.areaInterese = nucleo.getAreaIntervencao().getNome();
            }
        }
    }

    public Parcela() {};

    public List<Proprietario> getInteressados() {
        List<Proprietario> legitimados = new ArrayList<>();
        // if (Utils.isNotEmpty(this.imovel)) {
        if (Utils.isNotEmpty(this.imovel)){
            if (Utils.isNotEmpty(imovel.getProprietarios())) {
                for (Proprietario p : this.imovel.getProprietarios()) {
                    legitimados.add(p);
                }
            }
        }
        
        return legitimados;
        // } else if (Utils.isNotEmpty(this.nucleo)) {
        //     for (ProprietarioAtual p : processo.getProprietariosAtuais()) {
        //         Proprietario interessado = new Proprietario();

        //         interessado.setNome(p.getNomePessoa());
        //         interessado.setRazaoSocial(p.getRazaoSocial());

        //         if (Utils.isNotEmpty(p.getCpf())) {
        //             interessado.setCpf(Caracteres.removecaracter(p.getCpf()));
        //         }

        //         if (Utils.isNotEmpty(p.getCnpj())) {
        //             interessado.setCnpj(Caracteres.removecaracter(p.getCnpj()));
        //         }

        //         if (Utils.isNotEmpty(p.getOrgaoEmissor())) {
        //             interessado.setOrgaoEmissor(p.getOrgaoEmissor());
        //         }
        //         if (Utils.isNotEmpty(p.getEstadoCivil())) {
        //             interessado.setEstadoCivil(p.getEstadoCivil());
        //         }

        //         if (Utils.isNotEmpty(p.getSexo())) {
        //             interessado.setSexo(p.getSexo());
        //         }

        //         if (Utils.isNotEmpty(p.getRg())) {
        //             interessado.setRg(Caracteres.removecaracter(p.getRg()));
        //         }

        //         if (p.getNacionalidade() != null) {
        //             interessado.setNacionalidade(p.getNacionalidade());
        //         }

        //         // interessado.setBrasileiro(p.getNacionalidade() == Nacionalidade.BRASILEIRO);
        //         interessado.setProfissao(p.getProfissao());

        //         if (Utils.isNotEmpty(p.getDataNascimento())) {
        //             interessado.setDataNascimento(p.getDataNascimento());
        //         }

        //         interessado.setFiliacao1(p.getFiliacao1());
        //         interessado.setFiliacao1(p.getFiliacao2());

        //         interessado.setEndereco(p.getEndereco());
        //         if(!containsInteressado(legitimados, interessado)){
        //         legitimados.add(interessado);
        //         }
        //     }
        //     return legitimados;
        // }

        // return null;
    }

    public boolean containsInteressado(List<Proprietario> listaAtual, Proprietario legitimado) {
        for (Proprietario l : listaAtual) {
            if (l.getId().equals(legitimado.getId())) {
                return true;
            }
        }
        return false;
    }

}

