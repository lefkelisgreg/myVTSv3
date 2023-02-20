package gr.hua.dit.dsteam39.myVTSv3.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * @author Greg Lefkelis lef
 * DS Team id: 39
 * @project myVTSv3
 */

@Entity
@Table(name = "gov_offices")
public class govOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "govOffice")
    @JsonManagedReference
    private List<Seller> sellers;

    @OneToMany(mappedBy = "govOffice")
    @JsonManagedReference
    private List<Car> car;


    public govOffice(String name, String address, List<Car> car, List<Seller> sellers) {
        this.name = name;
        this.address = address;
        this.sellers = sellers;
        this.car = car;
    }

    public govOffice() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Car> getCar() {
        return car;
    }

    public void setCar(List<Car> car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }


    @Override
    public String toString() {
        return "govOffice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", sellers=" + sellers +
                ", car=" + car +
                '}';
    }
}
