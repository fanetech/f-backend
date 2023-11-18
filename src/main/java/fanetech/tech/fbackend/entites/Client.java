package fanetech.tech.fbackend.entites;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "telephone")
    private String telephone;
    private Date creation;
    @Column(name = "mis_a_jour")
    private Date misAjour;

    public Client() {
    }

    public Client(int id, String email, String telephone, Date creation, Date misAjour) {
        this.id = id;
        this.email = email;
        this.telephone = telephone;
        this.creation = creation;
        this.misAjour = misAjour;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getMisAjour() {
        return misAjour;
    }

    public void setMisAjour(Date misAjour) {
        this.misAjour = misAjour;
    }
}
