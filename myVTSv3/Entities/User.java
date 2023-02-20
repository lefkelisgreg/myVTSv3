package gr.hua.dit.dsteam39.myVTSv3.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Greg Lefkelis lef
 * DS Team id: 39
 * @project myVTSv3
 */

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String username;
    private String password;

    @Column(name = "VATnumber")
    @NotBlank(message = "VAT Number can't be empty.")
    @Size(max = 9, message = "Please Enter a valid Greek VAT Number")
    private int VATnumber;

    @Column(name = "first_name")
    @Size(max = 30)
    @NotBlank(message = "Name is REQUIRED")
    private String fname;

    @Column(name = "last_name")
    @Size(max = 30)
    @NotBlank(message = "Name is REQUIRED")
    private String lname;

    @Column(name = "email")
    @Email(message = "Please enter a valid email address")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    @Size(max = 10, message = "Enter valid phone number")
    private int phone;

    @Column(name = "birth")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;


    // Constructor START

    public User(int id, Role role, int VATnumber, String fname, String lname, String email, String address, int phone, Date birthDate) {
        this.id = id;
        this.role = role;
        this.VATnumber = VATnumber;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    // Constructor END

    public User() {

    }

    // Getters Setters START

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getVATnumber() {
        return VATnumber;
    }

    public void setVATnumber(int VATnumber) {
        this.VATnumber = VATnumber;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    // Getters Setters END

    // ToString


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role +
                ", VATnumber=" + VATnumber +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", birthDate=" + birthDate +
                '}';
    }
}
