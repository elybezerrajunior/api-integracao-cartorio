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

}
