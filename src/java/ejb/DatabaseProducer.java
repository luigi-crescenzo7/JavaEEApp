package ejb;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DatabaseProducer {
    
    @Produces
    @PersistenceContext(unitName = "db_torneo")
    private EntityManager em;
}
