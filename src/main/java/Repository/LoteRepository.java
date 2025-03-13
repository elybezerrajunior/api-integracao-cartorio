package Repository;
import Model.Imovel;
import Model.Lote;import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@RequestScoped
public class LoteRepository implements PanacheRepository<Lote> {

    @Inject
    EntityManager em;

    public Lote findByImovel(Imovel imovel) {
        String sql = "select l from Lote l where l.ativo = true and l.imovel = :imovel";

        var result = getEntityManager()
        .createQuery(sql, Lote.class)
        .setParameter("imovel", imovel)
        .getResultList();

        if (!result.isEmpty()) {
            return result.get(0);
        }
        return null;
    }
    
}
