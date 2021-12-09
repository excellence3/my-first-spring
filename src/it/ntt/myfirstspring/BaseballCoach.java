package it.ntt.myfirstspring;

public class BaseballCoach implements Coach {
    private FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }
    
    public String getDailyWorkout(){
        return "Spend 20 minutes on batting practice || " + 
                fortuneService.getFortune();
    }
}
