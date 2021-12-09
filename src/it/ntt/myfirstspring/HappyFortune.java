package it.ntt.myfirstspring;

public class HappyFortune implements FortuneService {

    @Override
    public String getFortune() {
        return "This is a lucky day!";
    }
    
    
}
