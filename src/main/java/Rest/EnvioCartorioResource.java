package Rest;

import java.util.ArrayList;
import java.util.List;

import Dto.EnvioCartorioDTO;
import Dto.MensagemRetornoAPIDTO;
import Dto.ParcelaDTO;
import Dto.RemessaDTO;
import Enum.TipoRemessa;
import Model.Imovel;
import Model.Lote;
import Model.Nucleo;
import Model.Orgao;
import Model.Parcela;
import Model.Remessa;
import Model.ServicoCartorio;
import Repository.ImovelRepository;
import Repository.LoteRepository;
import Repository.NucleoRepository;
import Repository.OrgaoRepository;
import Repository.RemessaRepository;
import Repository.ServicoCartorioRepository;
import Util.Utils;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/envioCartorio")
public class EnvioCartorioResource {
    private NucleoRepository nucleoRepository;
    private OrgaoRepository orgaoRepository;
    private ImovelRepository imovelRepository;
    private ServicoCartorioRepository servicoCartorioRepository;
    private RemessaRepository remessaRepository;
    private LoteRepository loteRepository;

    @Inject
    public EnvioCartorioResource(
        NucleoRepository nucleoRepository,
        OrgaoRepository orgaoRepository, ImovelRepository imovelRepository,
        ServicoCartorioRepository servicoCartorioRepository, RemessaRepository remessaRepository,
        LoteRepository loteRepository) {
        this.nucleoRepository = nucleoRepository;
        this.orgaoRepository = orgaoRepository;
        this.imovelRepository = imovelRepository;
        this.servicoCartorioRepository = servicoCartorioRepository;
        this.remessaRepository = remessaRepository;
        this.loteRepository = loteRepository;
    }

    @POST
    @Path("/obterEnvio")
    public Response obterEnvio(EnvioCartorioDTO envio) {
        MensagemRetornoAPIDTO retorno = salvarRemessa(envio);
        return Response.ok().entity(retorno).build();
    }

    public MensagemRetornoAPIDTO salvarRemessa(EnvioCartorioDTO envio) {
        try {
            Nucleo nucleo = nucleoRepository.findById(envio.getNucleoId());
            Orgao cartorio = orgaoRepository.findById(envio.getCartorioId());
            List<Imovel> imoveis = new ArrayList<>();
            List<ServicoCartorio> servicos = new ArrayList<>();
            List<Parcela> parcelas = new ArrayList<>();
            List<Parcela> parcelasDoNucleo = new ArrayList<>();
            TipoRemessa tipoRemessa = TipoRemessa.fromNome(envio.getTipoRemessa());
            Remessa remessa = new Remessa();
            
            envio.getServicosId().forEach(servico -> {servicos.add(servicoCartorioRepository.findById(servico));});
    
            if (Utils.isNotEmpty(envio.getImoveisId())) {
                envio.getImoveisId().forEach(imovel -> {imoveis.add(imovelRepository.findById(imovel));});
                imoveis.forEach(imovel -> {
                    parcelas.add(new Parcela(nucleo, servicos, imovel));
                });
                remessa = new Remessa(nucleo, cartorio, servicos, imoveis, parcelas, parcelasDoNucleo, tipoRemessa);
            } else {
                parcelasDoNucleo.add(new Parcela(nucleo, servicos, null));
                remessa = new Remessa(nucleo, cartorio, servicos, null, null, parcelasDoNucleo, tipoRemessa);
            }
    
            remessaRepository.salvar(remessa);

            MensagemRetornoAPIDTO retorno = new MensagemRetornoAPIDTO("Envio realizado com sucesso!", 200);
            return retorno;
        } catch (Exception ex) {
            return new MensagemRetornoAPIDTO(ex.getMessage(), 400);
        }
    }

    @GET
    @Path("/get")
    public Response getRemessas() {
        List<Remessa> remessas = remessaRepository.findRemessa();
        List<RemessaDTO> remessaDTOs = new ArrayList<>();

        remessas.forEach(item -> {
            List<ParcelaDTO> listParcela = new ArrayList<>();

            if (Utils.isNotEmpty(item.getParcelas())) {
                item.getParcelas().forEach(p -> {
                    Lote lote = loteRepository.findByImovel(p.getImovel());
                    listParcela.add(new ParcelaDTO(p, lote, item.getTipoRemessa()));
                });
            }

            if (Utils.isNotEmpty(item.getParcelasDoNucleo())) {
                item.getParcelasDoNucleo().forEach(p -> {
                    listParcela.add(new ParcelaDTO(p, null, item.getTipoRemessa()));
                });
            }

            remessaDTOs.add(new RemessaDTO(item, listParcela));
        });

        return Response.ok().entity(remessaDTOs).build();
    }

    @GET
    public String teste() {
        return "Hello";
    }
    
}
