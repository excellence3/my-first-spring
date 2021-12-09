package it.ntt.myfirstspring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) throws Exception {

        // senza spring...
        HappyFortune happyFortune = new HappyFortune();
        Coach baseballCoach = new BaseballCoach(happyFortune);
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

        // implemento la DI tramite constructor injection
        System.out.println("#######################");
        ClassPathXmlApplicationContext contextDIConstructor =
                new ClassPathXmlApplicationContext("applicationContextDIConstructor.xml");
        
        Coach myCoach2 = 
                contextDIConstructor.getBean("myDICoach", Coach.class);
        
        System.out.println(myCoach2.getDailyWorkout());
        contextDIConstructor.close();

        // implemento la DI tramite setter injection
        System.out.println("#######################");
        ClassPathXmlApplicationContext contextDISetter =
                new ClassPathXmlApplicationContext("applicationContextDISetter.xml");
        
        Coach myCoach3 =
                contextDISetter.getBean("myDICoach", Coach.class);
        
        System.out.println(myCoach3.getDailyWorkout());
        contextDISetter.close();
    }
}
