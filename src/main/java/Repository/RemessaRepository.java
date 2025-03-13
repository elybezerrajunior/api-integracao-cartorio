package Repository;
import java.util.List;

import Model.Remessa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@RequestScoped
public class RemessaRepository implements PanacheRepository<Remessa> {
    
    @Inject
    EntityManager em;

    @Transactional
    public void salvar(Remessa remessa) {
        em.persist(remessa);
    }

    public List<Remessa> findRemessa() {
        String sql = "select r from Remessa r where r.ativo = true";

        Query query = em.createQuery(sql);

        return query.getResultList();
    }

}
