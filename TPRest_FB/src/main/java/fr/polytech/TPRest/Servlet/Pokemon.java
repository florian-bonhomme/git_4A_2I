package fr.polytech.TPRest.Servlet;

import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pokemon")

public class Pokemon implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private int niveau;
    @OneToOne
    @JoinColumn(
            name = "type",
            referencedColumnName = "id"
    )
    private Type type;
    @ManyToOne
    @JoinColumn(
            name = "dresseur",
            referencedColumnName = "id"
    )
    private Dresseur dresseur;
    @ManyToMany(cascade = { CascadeType.ALL})
    @JoinTable(
            name = "pokemon_attaque",
            joinColumns = {@JoinColumn(name="id_pokemon")},
            inverseJoinColumns = {@JoinColumn(name = "id_attaque")}
    )
    Set<Attaque> attaques = new HashSet<>();


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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Dresseur getDresseur() {
        return dresseur;
    }

    public void setDresseur(Dresseur dresseur) {
        this.dresseur = dresseur;
    }

    public Set<Attaque> getAttaques() {
        return attaques;
    }

    public void setAttaques(Set<Attaque> attaques) {
        this.attaques = attaques;
    }

    public void addAttaque(Attaque attaque){
        this.attaques.add(attaque);
    }

    @Override
    public String toString() {
        return "Pokemon[nom=" + nom + ", niveau=" + niveau + "]";
    }
}
