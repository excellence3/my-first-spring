package it.ntt.myfirstspring;

public class TennisCoach implements Coach{

    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Try to hit the ball :P || " + 
                fortuneService.getFortune();
    }

    public void setFortuneService (FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }
    
}
