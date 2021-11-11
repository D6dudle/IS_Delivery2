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

    public void newUser(String name, String email, String password, LocalDateTime dob){
        System.out.println("Adding user " + name + "...");
        User u = new User(name, email, password, dob, false);
        em.persist(u);
    }

    public Boolean updateUser(User newUser){
        System.out.println("Updating user " + newUser.getName() + "...");
        TypedQuery<User> q = em.createQuery("UPDATE User u " +
                "SET u.name= :name, u.email= :email, u.password= :password, u.dob= :dob, u.isManager= :isManager" +
                "WHERE u.id= :id", User.class);
        q.setParameter("name", newUser.getName());
        q.setParameter("email", newUser.getEmail());
        q.setParameter("password", newUser.getPassword());
        q.setParameter("dob", newUser.getDob());
        q.setParameter("isManager", newUser.getManager());
        return q.executeUpdate() >= 1;
    }
}