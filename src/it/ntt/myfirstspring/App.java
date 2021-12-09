package it.ntt.myfirstspring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) throws Exception {
        Coach baseballCoach = new BaseballCoach();
        Coach trackCoach = new TrackCoach();

        System.out.println(baseballCoach.getDailyWorkout());
        System.out.println(trackCoach.getDailyWorkout());

        System.out.println("#######################");

        // utilizzo Spring
        ClassPathXmlApplicationContext context = 
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach myCoach = context.getBean("myCoach", Coach.class);

        System.out.println(myCoach.getDailyWorkout());

        context.close();
        
    }
}
