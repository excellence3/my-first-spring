package it.ntt.myfirstspring;

public class OtherFortune implements FortuneService {

    @Override
    public String getFortune() {
        return "This is just another fortune service";
    }
    
    public void doInitStuffs(){
        System.out.println("Initializing Other Fortune Service...");
    }

    public void doDestoyStuffs(){
        System.out.println("Destroying Other Fortune Service...");
    }
}
