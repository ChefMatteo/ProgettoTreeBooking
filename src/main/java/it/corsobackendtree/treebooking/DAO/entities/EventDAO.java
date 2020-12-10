package it.corsobackendtree.treebooking.DAO.entities;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
public class EventDAO {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    private String name;
    private LocalDateTime date;
    private String place;
    private Integer capacity;
    @ManyToOne(fetch = FetchType.LAZY)
    private UserDAO owner;
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<BookingDAO> eventReservations = new ArrayList<>();

    //constructors
    public EventDAO(String name, LocalDateTime date, String place, Integer capacity, UserDAO owner) {
        this.name = name;
        this.date = date;
        this.place = place;
        this.capacity = capacity;
        this.owner = owner;
    }
    public EventDAO() {
    }

    //getters
    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public String getPlace() {
        return place;
    }
    public Integer getCapacity() {
        return capacity;
    }
    public UserDAO getOwner() {
        return owner;
    }
    public List<BookingDAO> getEventReservations() {
        return eventReservations;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    public void setOwner(UserDAO owner) {
        this.owner = owner;
    }

    //hashcode&equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventDAO eventDAO = (EventDAO) o;
        return Objects.equals(id, eventDAO.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
