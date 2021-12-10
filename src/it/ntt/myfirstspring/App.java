package it.ntt.myfirstspring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.ntt.myfirstspring.config.ComponentScanConfig;

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
        
        System.out.println("Getting bean..");
        Coach myCoach3 =
                contextDISetter.getBean("myDICoach", Coach.class);
        
        System.out.println(myCoach3.getDailyWorkout());

        // utilizzo init e destroy methods
        System.out.println("##########Closing context...#############");
        
        contextDISetter.close();

        // utilizzo annotations
        System.out.println("##########Setter Annotation 1#############");
        ClassPathXmlApplicationContext contextAnnotations = 
                new ClassPathXmlApplicationContext("applicationContextAnnotations.xml");

        Coach myCoach4 = contextAnnotations.getBean("tennisCoach", Coach.class);


        System.out.println(myCoach4.getDailyWorkout());

        System.out.println("##########Field injection Annotation#############");
        Coach myCoach5 = contextAnnotations.getBean("soccerCoach", Coach.class);

        System.out.println(myCoach5.getDailyWorkout());

        contextAnnotations.close();

        System.out.println("##########Spring config with java code#############");

        AnnotationConfigApplicationContext contextJavaConfig =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);
                
        Coach myCoach6 = contextJavaConfig.getBean("soccerCoach", Coach.class);

        System.out.println(myCoach6.getDailyWorkout());

        contextJavaConfig.close();
        
    }
}
