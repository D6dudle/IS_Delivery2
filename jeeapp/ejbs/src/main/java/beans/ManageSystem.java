package beans;

import java.time.LocalDateTime;
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

    public void newTraveler(String name, String email, String password, LocalDateTime dob){
        System.out.println("Adding user " + name + "...");
        Traveler u = new Traveler(name, email, password, dob, false);
        em.persist(u);
    }

    public Boolean updateTraveler(Traveler newTraveler){
        System.out.println("Updating user " + newTraveler.getName() + "...");
        TypedQuery<Traveler> q = em.createQuery("UPDATE User u " +
                "SET u.name= :name, u.email= :email, u.password= :password, u.dob= :dob, u.isManager= :isManager" +
                "WHERE u.id= :id", Traveler.class);
        q.setParameter("name", newTraveler.getName());
        q.setParameter("email", newTraveler.getEmail());
        q.setParameter("password", newTraveler.getPassword());
        q.setParameter("dob", newTraveler.getDob());
        q.setParameter("isManager", newTraveler.getManager());
        return q.executeUpdate() >= 1;
    }
}