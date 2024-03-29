package it.sovy.Artem.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args) {

        // load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container
        CricketCoach cricketCoach = context.getBean("myCricketCoach", CricketCoach.class);

        // call methods on the beam
        System.out.println(cricketCoach.getDailyWorkout());

        System.out.println(cricketCoach.getDailyFortune());

        // call out new methods to get the literal values
        System.out.println(cricketCoach.getEmailAddress());

        System.out.println(cricketCoach.getTeam());

        // close the context
        context.close();

    }

}
