package fanetech.tech.fbackend.entites;

import fanetech.tech.fbackend.enums.TypeSentiment;
import jakarta.persistence.*;

@Entity
@Table(name = "SENTIMENT")
public class Sentiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String texte;
    private TypeSentiment typeSentiment;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "client_id")
    private  Client client;

    public Sentiment() {
    }

    public Sentiment(int id, String texte, TypeSentiment typeSentiment, Client client) {
        this.id = id;
        this.texte = texte;
        this.typeSentiment = typeSentiment;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public TypeSentiment getTypeSentiment() {
        return typeSentiment;
    }

    public void setTypeSentiment(TypeSentiment typeSentiment) {
        this.typeSentiment = typeSentiment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
