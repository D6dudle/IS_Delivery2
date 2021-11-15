package beans;

import data.Ticket;
import data.Traveler;
import data.Trip;

import java.time.LocalDate;
import java.util.List;

public interface IManageSystem {

    public Traveler tryLogin(String email, String password);

    public Traveler getTraveler(String email);

    public Boolean newTraveler(String name, String email, String password, LocalDate dob);

    public void updateTraveler(String name, String email, String password, LocalDate dob, Boolean isManager);

    public void deleteTraveler(String email);

    public List<Trip> listTrips(LocalDate beginFilter, LocalDate endFilter);

    public Double chargeWallet(String email, Double amount);

    public void buyTicket(String email, Integer tripID, Integer amount);

    public Boolean returnTicket(String email, Integer ticketID);

    public List<Trip> listMyTrips(String email);

    public List<Ticket> listMyTickets(String email);

    public Trip getTrip(Integer id);

    public void newTrip(LocalDate date, String dep, String des, Integer cap, Double price);

    public void deleteTrip(Integer tripID);

    public List<Traveler> listTravelersInTrip(Integer tripID);

    public void sendMail();

    public void addReceita(Double income);

    public List<Traveler> listTopTravelers();

}
