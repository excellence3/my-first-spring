package it.ntt.myfirstspring;

public class App {
    public static void main(String[] args) throws Exception {
        Coach baseballCoach = new BaseballCoach();
        Coach trackCoach = new TrackCoach();

        System.out.println(baseballCoach.getDailyWorkout());
        System.out.println(trackCoach.getDailyWorkout());
        
    }
}
