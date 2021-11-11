package data;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ticket
 *
 */
@Entity
public class Ticket implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Trip trip;
    @ManyToOne
    private User user;

    public Ticket() {
        super();
    }

    public Ticket(Trip trip, User user) {
        this.trip = trip;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}