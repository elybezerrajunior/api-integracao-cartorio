package Dto;

import Model.MatriculaAnterior;
import Util.Utils;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MatriculaAnteriorDTO {

    private String livro;

    private String numero_matricula;

    private String complemento_matricula;

    private String cns_cartorio;

    private String data_matricula;

    private String folha;

    private String descricao;

    public MatriculaAnteriorDTO(MatriculaAnterior matricula) {
        this.livro = matricula.getLivro();
        this.numero_matricula = matricula.getNumero_matricula();
        this.complemento_matricula = matricula.getComplemento_matricula();
        this.cns_cartorio = matricula.getCns();
        if (Utils.isNotEmpty(matricula.getData_matricula())) {
            this.data_matricula = matricula.getData_matricula().toString();
        }
        this.folha = matricula.getFolha();
        this.descricao = matricula.getDescricao();
    }

}
