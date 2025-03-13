package Repository;

import Model.Imovel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@RequestScoped
public class ImovelRepository implements PanacheRepository<Imovel> {
    
    @Inject
    EntityManager em;

}
