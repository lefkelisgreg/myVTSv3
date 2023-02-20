package gr.hua.dit.dsteam39.myVTSv3.Entities;

import javax.persistence.*;

/**
 * @author Greg Lefkelis lef
 * DS Team id: 39
 * @project myVTSv3
 */

@Entity
@Table(name = "buyer")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @OneToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;


    // Constructor START

    public Buyer(int id, User user, Seller seller, Car car) {
        this.id = id;
        this.user = user;
        this.seller = seller;
        this.car = car;
    }

    // Constructor END

    public Buyer() {
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

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    // Getters Setters END

    // ToString


    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", user=" + user +
                ", seller=" + seller +
                ", car=" + car +
                '}';
    }
}
