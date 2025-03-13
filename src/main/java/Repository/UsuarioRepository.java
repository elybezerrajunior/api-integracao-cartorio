package Repository;
import Model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@RequestScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {

    @Inject
    EntityManager em;

    public Usuario findByLogin(String login) {

        String jpql = "select u from Usuario u where u.login like :login and u.ativo = true";

        var result = getEntityManager()
                .createQuery(jpql, Usuario.class)
                .setParameter("login", login)
                .getResultList();

        if (!result.isEmpty()) {
            return result.get(0);
        }
        return null;

    }
    
}
