package beans;

import data.Traveler;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;

@Singleton
@Startup
public class SetUp {

    @PersistenceContext(unitName = "playAula")
    EntityManager em;

    @PostConstruct
    public void initialize() {
        String salt = PasswordUtils.getSalt(30);
        String mySecurePassword = PasswordUtils.generateSecurePassword("password123", salt);
        Traveler t = new Traveler("Manager1", "manager@email.com", mySecurePassword, LocalDate.now(), true);
        t.setSalt(salt);
        em.persist(t);
    }

    @PreDestroy
    public void remove(){
        em.createQuery("DELETE FROM Traveler t WHERE t.email LIKE 'manager@email.com'").executeUpdate();
    }
}
