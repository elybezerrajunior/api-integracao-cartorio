package Dto;

import Model.Anexo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnexoDTO  {

    private String nome;

    private String arquivo;

    private String nome_documento;

    private String documento_path;

    public AnexoDTO(Anexo anexo) {
        this.nome = anexo.getTituloAnexo();
        this.arquivo = "https://pi-cerurb.foxinline.com/imagens" + anexo.getUrl() + anexo.getNome();
        this.nome_documento = anexo.getTituloAnexo();
        this.documento_path = "https://pi-cerurb.foxinline.com/imagens" + anexo.getUrl() + anexo.getNome();
    }

}
