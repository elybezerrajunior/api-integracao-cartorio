package Repository;

import Model.ServicoCartorio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@RequestScoped
public class ServicoCartorioRepository implements PanacheRepository<ServicoCartorio> {
    
    @Inject
    EntityManager em;

}
