package it.sovy.Artem.springdemo_annotations;


public class SadFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "Today is a sad day!";
    }
}
