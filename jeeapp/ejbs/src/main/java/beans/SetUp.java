package beans;

import data.Traveler;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;

@Singleton
@Startup
public class SetUp {

    @PersistenceContext(unitName = "playAula")
    EntityManager em;

    @PostConstruct
    public void initialize(){
        Traveler t = new Traveler("Manager1", "manager@email.com", "password123", LocalDateTime.now(), true);
        em.persist(t);
    }

    @PreDestroy
    public void remove(){
        em.createQuery("DELETE FROM Traveler t WHERE t.email LIKE 'manager@email.com'").executeUpdate();
    }
}
