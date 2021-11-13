package data;
import java.io.Serializable;
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

    @ManyToOne(cascade = CascadeType.ALL)
    private Trip trip;

    @ManyToOne(cascade = CascadeType.ALL)
    private Traveler traveler;

    public Ticket() {
        super();
    }

    public Ticket(Trip trip, Traveler traveler) {
        this.trip = trip;
        this.traveler = traveler;
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

    public Traveler getUser() {
        return traveler;
    }

    public void setUser(Traveler traveler) {
        this.traveler = traveler;
    }
}