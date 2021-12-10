package it.ntt.myfirstspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SoccerCoach implements Coach {

    @Autowired
    @Qualifier("happyFortune")
    FortuneService fortuneService;


    @Override
    public String getDailyWorkout() {
        return "Kick the ball!  || " +
            fortuneService.getFortune();
    }
    
  
}
