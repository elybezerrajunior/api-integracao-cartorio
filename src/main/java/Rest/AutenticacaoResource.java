package Rest;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.SecretKey;

import Dto.TokenDTO;
import Dto.UsuarioResponseDTO;

import Model.Usuario;
import Repository.UsuarioRepository;
import Util.SenhaCripto;
import Util.Utils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/autenticacao")
public class AutenticacaoResource {

    private UsuarioRepository usuarioRepository;

    @Inject
    public AutenticacaoResource(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @POST
    @Path("/autenticar")
    public Response obterToken(@HeaderParam("login") String login, @HeaderParam("senha") String senha) {

        try {
            String json = "";
            TokenDTO tokenResponse = new TokenDTO();
            Usuario usuario = usuarioRepository.findByLogin(login);

            if (Utils.isNotEmpty(login)) {
                if (Utils.isNotEmpty(usuario)) {
                    if (Utils.isNotEmpty(usuario)) {
                        if (usuario.getSenha().equalsIgnoreCase(SenhaCripto.encryptPassword(senha))) {
                            SecretKey CHAVE = Keys.hmacShaKeyFor("7f-j&CKk=coNzZc0y7_4obMP?#TfcYq%fcD0mDpenW2nc!lfGoZ|d?f&RNbDHUX6"
                                    .getBytes(StandardCharsets.UTF_8));
                            String token = Jwts.builder()
                                    .setSubject(login)
                                    .signWith(SignatureAlgorithm.HS256, CHAVE)
                                    .compact();
                            tokenResponse.setToken(token);
                        } else {  
                            return Response.status(Response.Status.BAD_REQUEST).entity("Senha incorreta").build();
                        }
                    }
                } else {
                    return Response.status(Response.Status.BAD_REQUEST).entity("Não existe usuário com esse login").build();
                }
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Informe o login e senha no header da requisição").build();
            }
            return Response.status(Response.Status.OK)
                    .entity(tokenResponse).build();
        } catch (Exception ex) {
            System.out.println("caiu na exception do gerar token ");
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
    }

    @GET
    @Path("/getTokenUser")
    public Response obterUsuarioByToken(@HeaderParam("Authorization") String token) {
        try {
            if (Utils.isNotEmpty(token)) {

                token = token.replace("Bearer ", "").trim();

                SecretKey CHAVE = Keys.hmacShaKeyFor("7f-j&CKk=coNzZc0y7_4obMP?#TfcYq%fcD0mDpenW2nc!lfGoZ|d?f&RNbDHUX6"
                    .getBytes(StandardCharsets.UTF_8));
    
                Claims claims = Jwts.parserBuilder()
                        .setSigningKey(CHAVE)
                        .build()
                        .parseClaimsJws(token)
                        .getBody();
    
                String login = claims.getSubject();
    
                Usuario usuario = usuarioRepository.findByLogin(login);
    
                if (Utils.isNotEmpty(usuario)) {
                    UsuarioResponseDTO response = new UsuarioResponseDTO(usuario);
    
                    return Response.ok().entity(response).build();
                } else {
                    return Response.status(Response.Status.BAD_REQUEST).entity("Usuário não encontrado com esse login!").build();
                }
    
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Token não informado!").build();
            }
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
    }

    @GET
    public String teste() {
        return "Hello";
    }
    
}
