package it.sovy.Artem.springdemo_annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {

        // load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotation-applicationContext.xml");

        // retrieve bean from spring container
        Coach coach = context.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        // check if they are the same
        boolean check = (coach == alphaCoach); // if they are pointing at the same area in the memory

        // print out the results
        System.out.println("Pointing to the same object: " + check);

        System.out.println("Memory location for coach: " + alphaCoach);

        System.out.println("Memory location for alphaCoach: " + alphaCoach);

        // close context
        context.close();

    }
}
