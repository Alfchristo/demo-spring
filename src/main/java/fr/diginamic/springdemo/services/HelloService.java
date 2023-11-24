package fr.diginamic.springdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.Configuration;

@Service
public class HelloService {
    public String salutations(){
        return "Je suis la classe de service et je vous dis Bonjour";
    }
}
