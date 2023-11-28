package fr.diginamic.springdemo.entites;
import jakarta.persistence.*;

@Entity
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private int nbHabitant;

    public Ville(){
    }

    public Ville(int id, String nom, int nbHabitant) {
        this.nom = nom;
        this.nbHabitant = nbHabitant;
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
                return nom;
            }
    public void setNom(String nom) {
                this.nom = nom;
            }
    public int getNbHabitant() {
                return nbHabitant;
            }
    public void setNbHabitant(int nbHabitant) {
                this.nbHabitant = nbHabitant;
            }

}

