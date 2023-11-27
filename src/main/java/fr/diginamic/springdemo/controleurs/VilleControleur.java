package fr.diginamic.springdemo.controleurs;
import fr.diginamic.springdemo.entites.Ville;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

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
    public String insertVille(@RequestBody Ville nvVille) {
        if (!villes.contains(nvVille)) {
            villes.add(nvVille);
            return "Ville insérée avec succès";
        }
        return "non";
    }

    @PostMapping("/{id}")
    public Ville modifierVille(@PathVariable Integer id, @RequestBody Ville nVille){
        for (Ville v: villes){
            if (v.getId()==id){
                v.setNom(nVille.getNom());
                v.setNbHabitant(nVille.getNbHabitant());
                return v;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteVille(@PathVariable Integer id){
        Ville v = getVilleId(id);
        if (v == null){
            return;
        }
        villes.remove(v);
    }
}
