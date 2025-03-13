package Dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnvioCartorioDTO {
    private Long nucleoId;
    private List<Long> imoveisId;
    private List<Long> servicosId;
    private Long cartorioId;
    private String tipoRemessa;
    
    public EnvioCartorioDTO() {}

    public EnvioCartorioDTO(Long nucleoId, List<Long> imoveisId, List<Long> servicosId, Long cartorioId, String tipoRemessa) {
        this.nucleoId = nucleoId;
        this.imoveisId = imoveisId;
        this.servicosId = servicosId;
        this.cartorioId = cartorioId;
        this.tipoRemessa = tipoRemessa;
    }
    
}