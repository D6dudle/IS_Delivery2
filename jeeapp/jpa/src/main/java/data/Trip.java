package data;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Trip
 *
 */
@Entity
public class Trip implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDateTime date;
    private String departurePoint;
    private String destinationPoint;
    private Integer maxCapacity;
    @OneToMany(mappedBy = "trip")
    private List<Ticket> ticketsSold;
    private Double price;

    public Trip() {
        super();
    }

    public Trip(LocalDateTime date, String departurePoint, String destinationPoint, Integer maxCapacity, Double price) {
        this.date = date;
        this.departurePoint = departurePoint;
        this.destinationPoint = destinationPoint;
        this.maxCapacity = maxCapacity;
        this.price = price;
        this.ticketsSold = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(String destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Ticket> getTicketsSold() {
        return ticketsSold;
    }

    public void setTicketsSold(List<Ticket> ticketsSold) {
        this.ticketsSold = ticketsSold;
    }
}
