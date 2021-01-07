package runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import runner.Di.Bat;
import runner.badCouch.BaseballCoach;
import runner.bestCoach.BestCoach;
import runner.goodCoach.Coach;

@RestController
public class mycontroller {


    @RequestMapping("/")
    String getRoot(){
        return "<h> <button><a href= '/badCoach'> Bad Coach </button> </h> <button><a href= '/goodCoach'> Good Coach </button> <br> </h> <button><a href= '/bestCoach'> Best Coach </button>  <button><a href= '/Bat'> Give a Bat (DI) </button>";
    }

    @RequestMapping("/badCoach")
    String getBadCoach(){
        BaseballCoach baseballCoach= new BaseballCoach();
        return baseballCoach.getDailyWorkout();
    }

    @RequestMapping("/goodCoach")
    String getGoodCoach(){
        /*Inversion of Controller means inversing the control of creating the object, i.e rather than creating whatever is needed, the needed objects will be provided by the container
        For IoC the classes should come from an interface so that different types of object can be created..
        * and the app should be configurable which means myApp will tell which type of object it is looking for by annotation and object factory/container will give that type of object
        * in badCoach we see for CricketCoach we will need to edit both line 18 19 but if we use an interace then :*/
        Coach coach = new runner.goodCoach.BaseballCoach();
        return coach.getDailyWorkout();
        //then all we need is to edit 27th no line to use CricketCoach
    }

    //however it is still not coming from annotation, i.e we would still have to write CricketballCoach() on line 27 but we have to
    // do it using configuration/ annotation;
    @RequestMapping("/bestCoach")
    String bestCoach(){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("myCricketCoach");
        context.register(myConfiguration.class);
        context.refresh();
        BestCoach coach = context.getBean(BestCoach.class);
        return coach.getDailyWorkout();
        /*
        For XML based configuration :

        ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext();
        BestCoach coach1 = context1.getBean("myCricketCoach", BestCoach.class);
        return coach1.getDailyWorkout();

         */



    }


    /* Dependency Injection is a pattern to implement IoC. DI says give the object whatever it needs, object must not worry to create its dependencies
    This is done by implementing IoC container, whatever the dependencies of an object are, they will be provided by the Container.
    3 ways, constructor injection, method/setter injection, field/property injection

    Autowiring: when a property is annoted with Autowired, Spring searches for a class or interface that matches the type of that property.
    Hece it is called 'matches by type'. Spring will make the object and inject into that property. Hence it is called Autowiring.
    Also remember in our example we used @Component classes, so they produce beans, but we may use @bean to produce beans from method level too..
    *Constructor Injection: */

    private Bat bat;

    @Autowired
    public mycontroller(Bat thebat){
        bat=thebat;
    }

    @RequestMapping("/Bat")
    String getBat(){

        return bat.getBat();
    }
}
    /*when multiple implementations are present:
    make BaseballBat in DI package implement Bat then use Quantifier:

    private Bat bat;

    @Autowired
    public mycontroller(@Qualifier("thebatIuseLess")Bat thebat){
    bat=thebat;
    }

    @RequestMapping("/Bat")
    String getBat(){

        return bat.getBat();
    }
//NOW COMMENT FROM 77 TO 80 AD ADD
//
//    @Autowired
private Bat bat;
IT HAS BECOME FIELD INJECTION.

BUT CONSTRUCTOR INJECTIO IS BETTER THAN OTHER TWO AS IT MAKES THE OBJECT IMMUTABLE
     */

