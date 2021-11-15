package beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import data.*;

@Stateless
public class ManageSystem implements IManageSystem {
    @PersistenceContext(unitName = "playAula")
    EntityManager em;

    @Resource(mappedName="java:jboss/mail/Default")
    private Session mailSession;

    private Double receitasDiarias;

    public Traveler tryLogin(String email, String password){
        System.out.println("Logging in " + email + "...");
        Traveler t = em.find(Traveler.class, email);

        if (t != null && t.getPassword().equals(password))
            return t;
        else
            return null;
    }

    public Traveler getTraveler(String email){
        Traveler t = em.find(Traveler.class, email);
        return t;
    }

    public Boolean newTraveler(String name, String email, String password, LocalDate dob){
        System.out.println("Adding user " + name + "...");
        if (em.find(Traveler.class, email) == null) {
            Traveler u = new Traveler(name, email, password, dob, false);
            em.persist(u);
            return true;
        }
        return false;
    }

    public void updateTraveler(String name, String email, String password, LocalDate dob, Boolean isManager){
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
        em.createQuery("DELETE FROM Ticket WHERE traveler_email LIKE :email")
                .setParameter("email", email)
                .executeUpdate();
        em.createQuery("delete from Traveler t where t.email LIKE :email")
                .setParameter("email", email)
                .executeUpdate();
    }

    public List<Trip> listTrips(LocalDate beginFilter, LocalDate endFilter){
        System.out.println("Retrieving trips from the database...");
        TypedQuery<Trip> t = em.createQuery("FROM Trip t WHERE t.date >= :beginFilter AND t.date <= :endFilter", Trip.class)
                .setParameter("beginFilter", beginFilter)
                .setParameter("endFilter", endFilter);
        List<Trip> list = t.getResultList();
        return list;
    }//POR TESTAR

    public Double chargeWallet(String email, Double amount){
        System.out.println("Charging wallet " + email + "...");
        Traveler t = em.find(Traveler.class, email);
        t.setWallet(t.getWallet() + amount);
        em.merge(t);
        return t.getWallet();
    }

    public void buyTicket(String email, Integer tripID, Integer amount){
        System.out.println("Buying ticket " + email + " for " + tripID + "...");
        Traveler t = em.find(Traveler.class, email);
        for (int i=0; i< amount; i++){
            Trip trip = em.find(Trip.class, tripID);
            if (trip.getMaxCapacity()-trip.getTicketsSold().size()==0)
                return;
            if (chargeWallet(email, -trip.getPrice()) < 0) {
                chargeWallet(email, trip.getPrice());
                return;
            }
            else {
                Ticket ticket = new Ticket(trip, t);
                em.persist(ticket);
            }
        }
    }//POR TESTAR

    public Boolean returnTicket(String email, Integer ticketID){
        System.out.println("Returning ticket " + email + " for " + ticketID + "...");
        Ticket ticket = em.find(Ticket.class, ticketID);
        Trip trip = ticket.getTrip();

        if (trip.getDate().isAfter(LocalDate.now())) {

            Traveler t = em.find(Traveler.class, email);
            t.setWallet(t.getWallet() + trip.getPrice());
            em.merge(t);

            em.createQuery("delete from Ticket t where t.id=:id")
                    .setParameter("id", ticketID)
                    .executeUpdate();
            return true;
        }
        else {
            return false;
        }
    }

    public List<Trip> listMyTrips(String email){
        System.out.println("Retrieving trips from the database for user " + email + "...");
        List<Ticket> ticketList = em.find(Traveler.class, email).getTickets();
        List<Trip> list = new ArrayList<>();

        for (Ticket elem : ticketList){
            list.add(elem.getTrip());
        }
        return list;
    }

    public List<Ticket> listMyTickets(String email){
        System.out.println("Retrieving tickets from the database for user " + email + "...");
        List<Ticket> ticketList = em.find(Traveler.class, email).getTickets();
        return ticketList;
    }

    public Trip getTrip(Integer id){
        Trip t = em.find(Trip.class, id);
        return t;
    }

    public void newTrip(LocalDate date, String dep, String des, Integer cap, Double price){
        Trip t = new Trip(date, dep, des, cap, price);
        em.persist(t);
    }

    public void deleteTrip(Integer tripID){
        System.out.println("Deleting Trip " + tripID + "...");
        Trip trip = em.find(Trip.class, tripID);
        List<Ticket> ticketList = trip.getTicketsSold();

        for (Ticket elem : ticketList){
            returnTicket(elem.getUser().getEmail(), elem.getId());
            sendMailDeletedTicket("O(s) seu(s) bilhete(s) para a viagem de " +
                    elem.getTrip().getDeparturePoint() + " para " +
                    elem.getTrip().getDestinationPoint() + ", no dia " +
                    elem.getTrip().getDate() + "foi/foram cancelado(s) e o custo do(s) mesmo(s) foi reembolsado. " +
                            "Esperamos a sua compreensão", elem.getUser().getEmail());

        }

        em.createQuery("delete from Trip t where t.id = :id")
                .setParameter("id", tripID)
                .executeUpdate();
    }

    public List<Traveler> listTravelersInTrip(Integer tripID){
        Trip trip = em.find(Trip.class, tripID);
        List<Ticket> ticketList = trip.getTicketsSold();
        List<Traveler> travelersList = new ArrayList<>();

        for (Ticket elem : ticketList){
            travelersList.add(elem.getUser());
        }

        return travelersList.stream().distinct().collect(Collectors.toList());
    }

    public List<Traveler> listTopTravelers(){
        TypedQuery<String> ti = em.createQuery(
                "SELECT t.traveler.email " +
                        "FROM Ticket t " +
                        "GROUP BY t.traveler.email " +
                        "ORDER BY COUNT(t.id) DESC", String.class);
        List<String> ticketList = ti.getResultList();


        List<Traveler> list = new ArrayList<>();

        for (int i=0; i<5; i++){
            if (i==ticketList.size())
                break;
            list.add(getTraveler(ticketList.get(i)));
        }

        return list;
    }

    @Schedule(minute = "0", hour = "0")
    private void resetReceita(Double income){
        receitasDiarias = 0.0;
    }

    @Schedule(minute = "59", hour = "23")
    public void sendMail(){
        try {
            MimeMessage m = new MimeMessage(mailSession);
            Address from = new InternetAddress("henri.teix@gmail.com");
            Address[] to = new InternetAddress[]{new InternetAddress("de.moi.8.ns@gmail.com")};
            m.setFrom(from);
            m.setRecipients(Message.RecipientType.TO, to);
            m.setSubject("Sumario do dia");
            m.setSentDate(new java.util.Date());

            m.setContent("Revenue: " + this.receitasDiarias, "text/plain");
            Transport.send(m);
            //logger.info("Email de sumario enviado ->" + email);
        } catch (javax.mail.MessagingException e) {
            //logger.error(e.toString());
        }
    }

    private void sendMailDeletedTicket(String content, String email){
        try {
            MimeMessage m = new MimeMessage(mailSession);
            Address from = new InternetAddress("henri.teix@gmail.com");
            Address[] to = new InternetAddress[]{new InternetAddress(email)};
            m.setFrom(from);
            m.setRecipients(Message.RecipientType.TO, to);
            m.setSubject("O seu bilhete foi cancelado");
            m.setSentDate(new java.util.Date());

            m.setContent(content, "text/plain");
            Transport.send(m);
            //logger.info("Email de sumario enviado ->" + email);
        } catch (javax.mail.MessagingException e) {
            //logger.error(e.toString());
        }
    }

    public void addReceita(Double income){
        receitasDiarias += income;
    }
}