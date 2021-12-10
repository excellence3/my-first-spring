package it.ntt.myfirstspring;

import org.springframework.stereotype.Component;

@Component
public class HappyFortune implements FortuneService {

    @Override
    public String getFortune() {
        return "This is a lucky day!";
    }
    
    
}
