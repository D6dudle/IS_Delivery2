package beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import data.*;

@Stateless
public class ManageSystem implements IManageSystem {
    @PersistenceContext(unitName = "playAula")
    EntityManager em;

    /*
    public void addStudent(String name) {
        System.out.println("Adding student " + name + "...");
        Student s = new Student(name);
        em.persist(s);
    }

    public List<Student> listStudents() {
        System.out.println("Retrieving students from the database...");
        TypedQuery<Student> q = em.createQuery("from Student s", Student.class);
        List<Student> list = q.getResultList();
        return list;
    }*/

    public Boolean tryLogin(String email, String password){
        System.out.println("Logging in " + email + "...");
        Traveler t = em.find(Traveler.class, email);

        if (t != null && t.getPassword().equals(password))
            return true;
        else
            return false;
    }

    public void newTraveler(String name, String email, String password, LocalDateTime dob){
        System.out.println("Adding user " + name + "...");
        Traveler u = new Traveler(name, email, password, dob, false);
        em.persist(u);
    }

    public void updateTraveler(String name, String email, String password, LocalDateTime dob, Boolean isManager){
        System.out.println("Updating user " + name + "...");
        Traveler t = em.find(Traveler.class, email);
        t.setName(name);
        t.setPassword(password);
        t.setDob(dob);
        t.setManager(isManager);
        em.merge(t);
    }

    public void deleteTraveler(String email){
        System.out.println("Deleting " + email + "...");
        Traveler t = em.find(Traveler.class, email);
        em.remove(t);
    }//POR TESTAR - VERIFICAR SE FAZ CASCADE PARA OS BILHETES

    public List<Trip> listTrips(LocalDateTime beginFilter, LocalDateTime endFilter){
        System.out.println("Retrieving trips from the database...");
        TypedQuery<Trip> t = em.createQuery("FROM Trip t WHERE t.date >= :beginFilter AND t.date <= :endFilter", Trip.class)
                .setParameter("beginFilter", beginFilter.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "::date")
                .setParameter("endFilter", endFilter.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "::date");
        List<Trip> list = t.getResultList();
        return list;
    }//POR TESTAR

    public void chargeWallet(String email, Double amount){
        System.out.println("Charging wallet " + email + "...");
        Traveler t = em.find(Traveler.class, email);
        t.setWallet(t.getWallet() + amount);
        em.merge(t);
    }//POR TESTAR

    public void buyTicket(String email, Integer tripID, Integer amount){
        System.out.println("Buying ticket " + email + " for " + tripID + "...");
        Traveler t = em.find(Traveler.class, email);
        Trip trip = em.find(Trip.class, tripID);
        Ticket ticket = new Ticket(trip, t);
        em.persist(ticket);

        chargeWallet(email, -trip.getPrice());
    }//POR TESTAR
}