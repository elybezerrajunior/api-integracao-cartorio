package Repository;

import Model.Nucleo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@RequestScoped
public class NucleoRepository implements PanacheRepository<Nucleo> {
    
    @Inject
    EntityManager em;

}
