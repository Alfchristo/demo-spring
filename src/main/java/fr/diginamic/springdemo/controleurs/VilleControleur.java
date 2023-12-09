package fr.diginamic.springdemo.controleurs;
import fr.diginamic.springdemo.entites.Ville;
import fr.diginamic.springdemo.exception.ValidationException;
import fr.diginamic.springdemo.services.VilleService;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/villes")
public class VilleControleur {

    @PersistenceContext
    EntityManager em;

    @Autowired
    private VilleService villeService;


    @GetMapping
    public List<Ville> getVilles() {
        return villeService.extractVilles();
    }

    @GetMapping("/{id}")
    public Ville getVilleId(@PathVariable int id) {
        return villeService.extractVille(id);
    }

    @GetMapping("/nom/{nom}")
    public Ville getVilleNom(@PathVariable String nom) {
        return villeService.extractVille(nom);
    }

    @PutMapping
    public List<Ville> putVille(@RequestBody Ville ville) throws ValidationException {
        return villeService.insertVille(ville);
    }

    @PostMapping
    public List<Ville> postVille(@RequestBody Ville ville) {
        return villeService.modifierVille(ville.getId(), ville);
    }

    @DeleteMapping("/{id}")
    public List<Ville> deleteVille(@PathVariable int id) {
        return villeService.supprimerVille(id);
    }
}