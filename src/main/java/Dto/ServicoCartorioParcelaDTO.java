package Dto;

import Model.Parcela;
import Model.ServicoCartorio;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ServicoCartorioParcelaDTO {

    private TipoServicoDTO tipo_servico;

    private ProcessoImovelDTO processo_imovel;

    public ServicoCartorioParcelaDTO(ServicoCartorio servico, Parcela parcela) {
        this.tipo_servico = new TipoServicoDTO(servico.getCodigo());
        this.processo_imovel = new ProcessoImovelDTO(parcela.getInteressados());
    }

}
