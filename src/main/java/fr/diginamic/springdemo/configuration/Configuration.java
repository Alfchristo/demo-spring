package fr.diginamic.springdemo.configuration;

import org.springframework.stereotype.Component;

@org.springframework.context.annotation.Configuration
@Component
public class Configuration {
    public Configuration(){
        System.out.println("Hello j'utilise des service");
    }
}
