package fr.diginamic.springdemo.services;

import fr.diginamic.springdemo.entites.Ville;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleService {

    @PersistenceContext
    private EntityManager em;

    public List<Ville> extractVilles() {
        return em.createQuery("SELECT v FROM Ville v", Ville.class).getResultList();
    }

    public Ville extractVille(int idVille) {
        return em.find(Ville.class, idVille);
    }

    public Ville extractVille(String nom) {
        return em.createQuery("SELECT v FROM Ville v WHERE v.nom = :nom", Ville.class)
                .setParameter("nom", nom)
                .getSingleResult();
    }
@Transactional
    public List<Ville> insertVille(Ville ville) {
        em.persist(ville);
        return extractVilles();
    }
@Transactional
    public List<Ville> modifierVille(int idVille, Ville villeModifiee) {
        Ville villeBD = extractVille(idVille);
        villeBD.setNom(villeModifiee.getNom());
        villeBD.setNbHabitant(villeModifiee.getNbHabitant());
        villeBD.setCodeDepartement(villeModifiee.getCodeDepartement());
        em.merge(villeBD);
        return extractVilles();
    }
@Transactional
    public List<Ville> supprimerVille(int idVille) {
        Ville villeBD = extractVille(idVille);
        em.remove(villeBD);
        return extractVilles();
    }
}