package gr.hua.dit.dsteam39.myVTSv3.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

/**
 * @author Greg Lefkelis lef
 * DS Team id: 39
 * @project myVTSv3
 */

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    @DateTimeFormat(pattern = "yyyy")
    private int year;

    @Column(name = "vinNo") // ΑΡΙΘΜΟΣ ΠΛΑΙΣΙΟΥ - ΚΑΤΑΣΚΕΥΑΣΤΗ
    private String vinnumber;

    @Column(name = "licenseNo") // ΑΡ ΑΔΕΙΑΣ ΚΥΚΛΟΦΟΡΙΑΣ
    private String licensenumber;

    @Column(name = "registerNo") // ΑΡ ΠΙΝΑΚΙΔΑΣ
    private String registernumber;


    // Relationships START

    @ManyToOne
    @JoinColumn(name = "seller_id")
    @JsonBackReference
    private Seller seller;

    @OneToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "gov_office_id")
    @JsonBackReference
    private govOffice govOffice;


    // Relationships END


    // Constructor START

    public Car(String brand, String model, int year, String vinnumber, String licensenumber, String registernumber, Seller seller, Buyer buyer, gr.hua.dit.dsteam39.myVTSv3.Entities.govOffice govOffice) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.vinnumber = vinnumber;
        this.licensenumber = licensenumber;
        this.registernumber = registernumber;
        this.seller = seller;
        this.buyer = buyer;
        this.govOffice = govOffice;
    }


    // Constructor END

    public Car() {
    }

    //Getters Setters START

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVinnumber() {
        return vinnumber;
    }

    public void setVinnumber(String vinnumber) {
        this.vinnumber = vinnumber;
    }

    public String getLicensenumber() {
        return licensenumber;
    }

    public void setLicensenumber(String licensenumber) {
        this.licensenumber = licensenumber;
    }

    public String getRegisternumber() {
        return registernumber;
    }

    public void setRegisternumber(String registernumber) {
        this.registernumber = registernumber;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public gr.hua.dit.dsteam39.myVTSv3.Entities.govOffice getGovOffice() {
        return govOffice;
    }

    public void setGovOffice(gr.hua.dit.dsteam39.myVTSv3.Entities.govOffice govOffice) {
        this.govOffice = govOffice;
    }

    //Getter Setters END


    //toString


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", manufacturerNumber='" + vinnumber + '\'' +
                ", licenseNumber='" + licensenumber + '\'' +
                ", RegistrationNumber='" + registernumber + '\'' +
                ", seller=" + seller +
                ", buyer=" + buyer +
                ", govOffice=" + govOffice +
                '}';
    }
}