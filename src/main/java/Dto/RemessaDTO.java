package Dto;

import java.util.ArrayList;
import java.util.List;
import Model.Nucleo;
import Model.Remessa;
import Util.DateUtils;
import Util.Utils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemessaDTO {

    private String numero_remessa;

    private String data_remessa;

    private String cns;

    private String nome_cartorio;

    private ProprietarioAtualDTO proprietario_atual;

    private RequerenteDTO requerente;

    private List<ParcelaDTO> parcelas;

    private List<AnexoDTO> documentos_remessa;

    public RemessaDTO(Remessa remessa, List<ParcelaDTO> parcelas) {

        this.numero_remessa = remessa.getId().toString();

        if (Utils.isNotEmpty(remessa.getDataCriacao())) {
            this.data_remessa = DateUtils.format(DateUtils.localDateTimeToDate(remessa.getDataCriacao()));
        }

        if (Utils.isNotEmpty(remessa.getCartorio())) {
            this.cns = remessa.getCartorio().getCodigoServentia();
            this.nome_cartorio = remessa.getCartorio().getNome();
            this.proprietario_atual = new ProprietarioAtualDTO(remessa.getProprietarioAtual());
            this.requerente = new RequerenteDTO(remessa.getRequerente());
        }

        if (Utils.isNotEmpty(parcelas)) {
            this.parcelas = parcelas;
        }

        if (Utils.isNotEmpty(remessa.getNucleo())) {
            Nucleo nucleo = remessa.getNucleo();

            if (Utils.isNotEmpty(nucleo.getAnexos())) {
                documentos_remessa = new ArrayList<>();
                nucleo.getAnexos().forEach(a -> documentos_remessa.add(new AnexoDTO(a)));
            }
        }
        
    }
}
