package Dto;

import Model.Usuario;
import Util.Utils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsuarioResponseDTO {

    private String login;
    private String senha;
    private String nome;
    private Long idCredenciada;
    private Long idColetador;

    public UsuarioResponseDTO(Usuario usuario) {
        if (Utils.isNotEmpty(usuario.getCredenciada())) {
            this.idCredenciada = usuario.getCredenciada().getId();
        }

        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.nome = usuario.getNome();

        if (Utils.isNotEmpty(usuario.getId())) {
            this.idColetador = usuario.getId();
        }
    }

}
