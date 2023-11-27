package fr.diginamic.springdemo.controleurs;
import fr.diginamic.springdemo.entites.Ville;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/villes")
public class VilleControleur {

    private ArrayList<Ville> villes = new ArrayList<>();

   @GetMapping
   public List<Ville> getVilles() {
       return villes;
   }

    @GetMapping("/{id}")  //TP 5
    public Ville getVilleId(@PathVariable int id){
        for (Ville v : villes){
            if (v.getId() == id){
                return v;
            }
        }
        return null;
    }

    @PutMapping
    public ResponseEntity<String> insertVille(@RequestBody Ville nvVille) {
        if (!villes.contains(nvVille)) {
            villes.add(nvVille);
            return ResponseEntity.ok("Ville insérée avec succès");
        }
        return ResponseEntity.badRequest().body("La ville existe déjà");
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> modifierVille(@PathVariable int id, @RequestBody Ville nVille){
       if (id<=0){
           return ResponseEntity.badRequest().body("Identifiant incorrect");
       }
       for (Ville v: villes){
            if (v.getId()==id){
                v.setNom(nVille.getNom());
                v.setNbHabitant(nVille.getNbHabitant());
                return ResponseEntity.ok("Ville modifier avec succes");
            }
        }
        return ResponseEntity.badRequest().body("Erreur, identifiant: "+id+"non trouver");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVille(@PathVariable int id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().body("L'identifiant est incorrect");
        }
        Iterator<Ville> iterVilles = villes.iterator();
        while (iterVilles.hasNext()) {
            Ville v = iterVilles.next();
            if (v.getId() == id) {
                iterVilles.remove();
                return ResponseEntity.ok("Ville supprimé");
            }
        }
        return ResponseEntity.badRequest().body("La ville avec l'id "+ id + "n'a pas été trouvée");
    }
}
