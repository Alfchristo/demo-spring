package fr.diginamic.springdemo.controleurs;

import fr.diginamic.springdemo.configuration.Configuration;
import fr.diginamic.springdemo.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloControleur {

    @GetMapping
    public String direHello(){
        return service.salutations();
    }

    @GetMapping("/salut")
    public String direSalut(){
        return "Salut";
    }
    @Autowired
    private Configuration config;  // non fini

    @Autowired
    private HelloService service;
    }