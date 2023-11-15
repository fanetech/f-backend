package fanetech.tech.fbackend.entites;


import jakarta.persistence.*;

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

    public Client() {
    }

    public Client(int id, String email, String telephone) {
        this.id = id;
        this.email = email;
        this.telephone = telephone;
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
}
