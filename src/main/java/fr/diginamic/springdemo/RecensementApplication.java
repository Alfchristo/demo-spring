package fr.diginamic.springdemo;

import fr.diginamic.springdemo.entites.Ville;
import fr.diginamic.springdemo.services.VilleService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@SpringBootApplication
public class RecensementApplication implements CommandLineRunner {

    @Autowired
    private VilleService villeService;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication();
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        Path path = Paths.get("C:/dev-java/recensement.csv");
        List<String> lignes = Files.readAllLines(path);
        lignes.remove(0);
        for (String ligne: lignes){
            System.out.println(ligne);
            String[] elements = ligne.split(";");
            Ville ville = new Ville();
            ville.setCodeDepartement(elements[2]);
            ville.setNom(elements[6]);
            ville.setNbHabitant(Integer.parseInt(elements[9].replaceAll(" ", "")));
            villeService.insertVille(ville);
        }
    }
}
