package gr.hua.dit.dsteam39.myVTSv3.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Greg Lefkelis lef
 * DS Team id: 39
 * @project myVTSv3
 */

@Entity
@Table(name = "sellers")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @OneToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @OneToMany(mappedBy = "seller", cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.DETACH})
    @JsonManagedReference
    private List<Car> cars;

    @ManyToOne
    @JoinColumn(name = "gov_office_id")
    @JsonBackReference
    private govOffice govOffice;

    // Constructor START

    public Seller(int id, User user, Buyer buyer, List<Car> cars, gr.hua.dit.dsteam39.myVTSv3.Entities.govOffice govOffice) {
        this.id = id;
        this.user = user;
        this.buyer = buyer;
        this.cars = cars;
        this.govOffice = govOffice;
    }

    //Constructor END

    public Seller() {

    }

    // Getters Setters START

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public gr.hua.dit.dsteam39.myVTSv3.Entities.govOffice getGovOffice() {
        return govOffice;
    }

    public void setGovOffice(gr.hua.dit.dsteam39.myVTSv3.Entities.govOffice govOffice) {
        this.govOffice = govOffice;
    }

    // Getters Setters END

    public void add(Car car) {
        if (car == null) {
            cars = new ArrayList<>();
        }
        cars.add(car);
        car.setSeller(this);

    }


    // to String

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", user=" + user +
                ", buyer=" + buyer +
                ", cars=" + cars +
                ", govOffice=" + govOffice +
                '}';
    }
}
