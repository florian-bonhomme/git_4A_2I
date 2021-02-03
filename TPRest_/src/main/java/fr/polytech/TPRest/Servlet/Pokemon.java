package fr.polytech.TPRest.Servlet;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pokemon")

public class Pokemon implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private int niveau;

    public Pokemon() {}

    public Pokemon(int id , String nom, int niveau) {
        this.id = id;
        this.nom = nom;
        this.niveau = niveau;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    @Override
    public String toString() {
        return "Pokemon[nom=" + nom + ", niveau=" + niveau + "]";
    }
}
