package data;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Traveler
 *
 */
@Entity
public class Traveler implements Serializable {
    private static final Long serialVersionUID = 1L;

    private String name;
    @Id
    private String email;
    private String password;
    private String salt;
    private LocalDate dob;
    private Boolean isManager;
    private Double wallet;
    @OneToMany(mappedBy = "traveler", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Ticket> tickets;

    public Traveler() {
        super();
    }

    public Traveler(String name, String email, String password, LocalDate dob, Boolean isManager) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.isManager = isManager;
        this.wallet = 0.0;
        this.tickets = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Boolean getManager() {
        return isManager;
    }

    public void setManager(Boolean manager) {
        isManager = manager;
    }

    public Double getWallet() {
        return wallet;
    }

    public void setWallet(Double wallet) {
        this.wallet = wallet;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}