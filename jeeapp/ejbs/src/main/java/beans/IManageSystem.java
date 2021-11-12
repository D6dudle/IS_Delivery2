package beans;

import data.Traveler;

import java.time.LocalDateTime;

public interface IManageSystem {
    public void newTraveler(String name, String email, String password, LocalDateTime dob);

    public Boolean updateTraveler(Traveler newTraveler);
}
