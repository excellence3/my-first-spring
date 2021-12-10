package it.ntt.myfirstspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SoccerCoach implements Coach {

    @Value("${coach.name}")
    private String name;

    @Value("${coach.surname}")
    private String surname;

    @Autowired
    @Qualifier("happyFortune")
    FortuneService fortuneService;


    @Override
    public String getDailyWorkout() {
        return name + " " + surname + ": Kick the ball!  || " +
            fortuneService.getFortune();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
  
}
