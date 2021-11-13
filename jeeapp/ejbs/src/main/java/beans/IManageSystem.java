package beans;

import data.Traveler;
import data.Trip;

import java.time.LocalDateTime;
import java.util.List;

public interface IManageSystem {

    public Boolean tryLogin(String email, String password);

    public void newTraveler(String name, String email, String password, LocalDateTime dob);

    public void updateTraveler(String name, String email, String password, LocalDateTime dob, Boolean isManager);

    public void deleteTraveler(String email);

    public List<Trip> listTrips(LocalDateTime beginFilter, LocalDateTime endFilter);

    public void chargeWallet(String email, Double amount);

    public void buyTicket(String email, Integer tripID, Integer amount);

    public Boolean returnTicket(String email, Integer ticketID);

    public List<Trip> listMyTrips(String email);
}
