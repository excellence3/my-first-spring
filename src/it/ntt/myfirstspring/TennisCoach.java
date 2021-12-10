package it.ntt.myfirstspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    private FortuneService fortuneService;


    @Override
    public String getDailyWorkout() {
        return "Try to hit the ball :P || " + 
                fortuneService.getFortune();
    }

    @Autowired
    @Qualifier("otherFortune")
    public void setFortuneService (FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }

    public void doInitStuffs(){
        System.out.println("Initializing Tennis Coach...");
    }

    public void doDestoyStuffs(){
        System.out.println("Destroying Tennis Coach...");
    }
    
}
