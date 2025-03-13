package Dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CertificacaoDTO implements Serializable {

    private String perimetro_geo;

    private String memorial_descritivo_analitico;

    private String memorial_descritivo_pdf;

    private String planta_a4_pdf;

    private String sistema_geo;



}
