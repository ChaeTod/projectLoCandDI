package it.sovy.Artem.springdemo_annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.PostLoad;
import javax.persistence.PreRemove;

//@Component("thatSillyCoach")  // special annotation that Spring will use while scanning our classes. That annotation - bean id. Spring will automatically register this bean.
@Component  // now this uses the default bean id "tennisCoach"
@Scope("prototype") // create a instance of Coach every time - when it's gonna request for tennis coach it is gonna create a new instance every time
public class TennisCoach implements Coach{

    @Autowired  // field injection
    //@Qualifier("happyFortuneService")  // bean name to inject
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    // define a default constructor
    public TennisCoach(){
        System.out.println(">> TrainingCoach: inside default constructor");
    }

    // define my init method
    //@PostConstruct
    @PostConstruct // code will execute after constructor and after injection of dependencies
    public void doMyStartupStuff(){
        System.out.println(">> TennisCoach: inside doMyStartupStuff() ");
    }

    // define my destroy method
    //@PreDestroy
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println(">> TennisCoach: inside doMyCleanupStuff() ");
    }

    /*@Autowired   // inject dependencies by calling ANY method with @Autowired
    public void doSomeCrazyStuff(FortuneService fortuneService){
        System.out.println(">> TrainingCoach: inside doSomeCrazyStuff() method");
        this.fortuneService = fortuneService;
    }*/

    /*// define a setter method
    @Autowired   // when Spring will see this method it will understands that it should resolve dependency and inject it
    public void setFortuneService(FortuneService fortuneService){
        System.out.println(">> TrainingCoach: inside setFortuneService() method");
        this.fortuneService = fortuneService;
    }*/

    /*@Autowired  // configure dependency injection with annotation - spring will scan for a component that implements FortuneService interface
    public TennisCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }*/

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
