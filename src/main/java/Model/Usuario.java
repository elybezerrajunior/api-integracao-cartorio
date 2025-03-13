package Model;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario extends EntidadeGenerica {

    @Id
    @SequenceGenerator(sequenceName = "seq_usuario", name = "seq_usuario", initialValue = 3, allocationSize = 1)
    @GeneratedValue(generator = "seq_usuario", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;

    private String email;
    private String login;
    private String senha;

    // @ManyToMany(fetch = FetchType.LAZY)
    // private List<Grupo> grupos;

    @ManyToOne(fetch = FetchType.LAZY)
    private Orgao orgao;

    private String cpf;

    private String telefone;

    // @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // private Anexo fotoPerfil;

    @JsonIgnore
    private boolean aptoParaAssumirNovaAnalise;

    // @OneToOne(fetch = FetchType.LAZY)
    // @JsonIgnore
    // private Imovel ultimoImovelAssumidoAnalise;

    @JsonIgnore
    private Boolean avisoAtualizacaoVizualizado;

    private Boolean senhaforte;

    @JsonIgnore
    public static String encryptPassword(String senha) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bs;
            messageDigest.reset();
            bs = messageDigest.digest(senha.getBytes());

            for (int i = 0; i < bs.length; i++) {
                String hexVal = Integer.toHexString(0xFF & bs[i]);
                if (hexVal.length() == 1) {
                    stringBuilder.append("0");
                }
                stringBuilder.append(hexVal);
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return stringBuilder.toString();
    }


}
