package Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public enum CaminhoPastaAnexo {

    AFORAMENTO("Aforamento", "aforamento/"),
    IMOVEL("Imovel", "imovel/"),
    IMOVEL_BACKUP("Imovel Backup", "imovel_backup/"),
    ASSINATURA("Assinatura", "assinatura/"),
    EDIFICACAO("Edificacao", "edificacao/"),
    FINANCEIRO("Financeiro", "financeiro/"),
    NUCLEO("Nucleo", "nucleo/"),
    PROTOCOLO("Protocolo", "protocolo/"),
    PROPRIETARIO("Proprietario", "proprietario/"),
    TRAMITE_NUCLEO("Tramite Nucleo", "tramite_nucleo/"),
    TRAMITE_IMOVEL("Tramite Imovel", "tramite_imovel"),
    TRAMITE_PROTOCOLO("Tramite Protocolo", "tramite_protocolo/"),
    IMAGEM_DOCUMENTO("Imagem Documento", "imagem_documento/"),
    CREDENCIADA("Tramite Protocolo", "credenciada/"),
    DOCUMENTO_CABECALHO("Cabeçalho", "cabecalho/"),
    DOCUMENTO_RODAPE("Rodape", "rodape/"),
    TIMBRADO("Timbrado", "timbrado/"),
    SHAPE("Shape", "shape/"),
    USUARIO("Usuario", "usuario/");

    private String nome;
    private String url;

    public static CaminhoPastaAnexo valueString(String valor) {
        for (CaminhoPastaAnexo o : values()) {
            if (o.getNome().toLowerCase().equals(valor.toLowerCase())) {
                return o;
            }
        }
        return null;
    }

}
