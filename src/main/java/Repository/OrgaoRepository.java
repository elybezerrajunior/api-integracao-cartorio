package Repository;

import Model.Orgao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@RequestScoped
public class OrgaoRepository implements PanacheRepository<Orgao> {
    
    @Inject
    EntityManager em;

    public Orgao findOrgaoCns(String cns) {

        String sql = "select o from Orgao o where o.ativo = true and o.codigoServentia like :cns";

        var result = getEntityManager()
        .createQuery(sql, Orgao.class)
        .setParameter("cns", cns)
        .getResultList();

        if (!result.isEmpty()) {
            return result.get(0);
        }
        return null;
    }

}
