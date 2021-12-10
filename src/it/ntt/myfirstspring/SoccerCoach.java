package it.ntt.myfirstspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach {

    FortuneService fortuneService;


    @Override
    public String getDailyWorkout() {
        return "Kick the ball!  || " +
            fortuneService.getFortune();
    }
    
    @Autowired
    @Qualifier("happyFortune")
    public void setFortuneService(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }
}
