package Dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import Enum.TipoRemessa;
import Model.Dimensao;
import Model.Imovel;
import Model.Lote;
import Model.Nucleo;
import Model.Parcela;
import Model.Shape;
import Util.Utils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParcelaDTO {

    private Long id;

    private Long id_lote;

    private String identificacao;

    private String numeroLote;

    private String numeroQuadra;

    private String areaLote;

    private String numero_parcela;

    private BigDecimal area_total_ha;

    private String categoria;

    private MunicipioDTO municipio;

    private AreaInteresseDTO area_interesse;

    private MatriculaAnteriorDTO matricula;

    private MatriculaAnteriorDTO matricula_anterior;

    private CertificacaoDTO certificacao_sigef;

    private List<ServicoCartorioParcelaDTO> servicoscartorio_parcela;

    private BigDecimal perimetro;

    private EnderecoDTO endereco;

    private TituloDTO titulo;

    private List<AnexoDTO> documentos;

    private String frente;

    private String fundo;

    private String lado_esquerdo;

    private String lado_direito;

    private BigDecimal area_construida;

    private String zona;

    private List<ComodoDTO> comodos;

    public ParcelaDTO(Parcela parcela, Lote lote, TipoRemessa tipoRemessa) {
        Imovel imovel = parcela.getImovel();

        this.id = parcela.getId();
        this.numeroLote = parcela.getNumeroLote();
        this.numeroQuadra = parcela.getNumeroQuadra();

        titulo = new TituloDTO();
        titulo.setTipo("Regularização Fundiária REURB");

        this.certificacao_sigef = new CertificacaoDTO();
        this.certificacao_sigef.setMemorial_descritivo_analitico(parcela.getTextoMemorial());
        this.certificacao_sigef.setMemorial_descritivo_pdf("");
        this.certificacao_sigef.setSistema_geo("COORDENADAS GEOGRÁFICAS SIRGAS - 2000");
        this.certificacao_sigef.setPlanta_a4_pdf("");

        this.area_interesse = new AreaInteresseDTO(parcela.getAreaInterese());
        this.area_interesse.setNome(parcela.getAreaInterese());

        if (Utils.isNotEmpty(parcela.getNucleo())) {
            Nucleo nucleo = parcela.getNucleo();

            if (Utils.isNotEmpty(nucleo.getCidade())) {
                this.municipio = new MunicipioDTO(nucleo.getCidade());
            }

            if (Utils.isNotEmpty(nucleo.getRegiao())) {
                this.zona = nucleo.getRegiao().getNome();
            }
        }

        if (tipoRemessa == TipoRemessa.NUCLEO) {
            if (Utils.isNotEmpty(parcela.getNucleo())) {
                Nucleo nucleo = parcela.getNucleo();

                this.identificacao = "GLEBA " + nucleo.getNome();
                if (Utils.isNotEmpty(nucleo.getShape())) {
                    Shape shape = nucleo.getShape();

                    this.certificacao_sigef.setPerimetro_geo((shape.getCoordenadasToNotario()));
                    this.frente = shape.getFrente();
                    this.fundo = shape.getFundo();
                    this.lado_esquerdo = shape.getEsquerda();
                    this.lado_direito = shape.getDireita();
                    this.area_total_ha = shape.getArea();
                    this.perimetro = shape.getPerimetro();
                }

                if (Utils.isNotEmpty(nucleo.getAnexos())) {
                    documentos = new ArrayList<>();
                    nucleo.getAnexos().forEach(a -> documentos.add(new AnexoDTO(a)));
                }

            }
        } else if (tipoRemessa == TipoRemessa.LOTE) {

            if (Utils.isNotEmpty(lote.getShape())) {
                this.certificacao_sigef.setPerimetro_geo(lote.getShape().getCoordenadasToNotario());
            }

            if (Utils.isNotEmpty(imovel)) {
                this.frente = imovel.getFrente();
                this.fundo = imovel.getFundo();
                this.lado_esquerdo = imovel.getLadoEsquerdo();
                this.lado_direito = imovel.getLadoDireito();

                if (Utils.isNotEmpty(imovel.getTipoDoImovel())) {
                    this.categoria = "LOTE";
                }
    
                if (Utils.isNotEmpty(imovel.getDimensao())) {
                    Dimensao dimensao = imovel.getDimensao();

                    this.areaLote = dimensao.getAreaTerreno().toString();
                    this.area_total_ha = dimensao.getAreaTerreno();
                    this.perimetro = dimensao.getPerimetro();
                    this.area_construida = dimensao.getAreaTotalEdificacao();
                }
    
                if (Utils.isNotEmpty(imovel.getEnderecoImovel())) {
                    this.endereco = new EnderecoDTO(imovel.getEnderecoImovel());
                }
    
                if (Utils.isNotEmpty(imovel.getAnexos())) {
                    documentos = new ArrayList<>();
                    imovel.getAnexos().forEach(a -> documentos.add(new AnexoDTO(a)));
                }
    
                if (Utils.isNotEmpty(imovel.getEdificacoes())) {
                    List<ComodoDTO> list = new ArrayList<>();
                    imovel.getEdificacoes().forEach(e -> {
                        e.getComodos().forEach(c -> {
                            list.add(new ComodoDTO(c));
                        });
                    });
                    comodos = list;
                }
    
            }

            if (Utils.isNotEmpty(lote)) {
                this.id_lote = lote.getId();
                this.identificacao = "LOTE " + lote.getNumero();
            }

        }

        if (Utils.isNotEmpty(parcela.getMatriculaAnterior())) {
            this.matricula_anterior = new MatriculaAnteriorDTO(parcela.getMatriculaAnterior());
        }

        if (Utils.isNotEmpty(parcela.getMatricula())) {
            this.matricula = new MatriculaAnteriorDTO(parcela.getMatricula());
        }
        
        if (Utils.isNotEmpty(parcela.getServicos())) {
            servicoscartorio_parcela = new ArrayList<>();
            parcela.getServicos().forEach(s -> servicoscartorio_parcela.add(new ServicoCartorioParcelaDTO(s, parcela)));
        }

    }

}
