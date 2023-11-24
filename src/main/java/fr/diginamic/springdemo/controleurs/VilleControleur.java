package fr.diginamic.springdemo.controleurs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/villes")
public class VilleControleur {
    public class Ville {

        private String nom;
        private int nbHabitant;

        public Ville(String nom, int nbHabitant) {
            this.nom = nom;
            this.nbHabitant = nbHabitant;
        }
        public String getNom() {
            return nom;
        }
        public void setNom(String nom) {
            this.nom = nom;
        }
        public int getnbHabitant() {
            return nbHabitant;
        }
        public void setNbHabitant(int nbHabitant) {
            this.nbHabitant = nbHabitant;
        }
    }

    @GetMapping
    public List<Ville> getVilles() {
        return List.of(
                new Ville("Nice", 340000),
                new Ville("Lyon", 484000),
                new Ville("Narbonne", 53400),
                new Ville("Lyon", 484000),
                new Ville("Foix", 9700),
                new Ville("Pau", 77200),
                new Ville("Marseille", 850700),
                new Ville("Tarbes", 40600)
        );
    }
}