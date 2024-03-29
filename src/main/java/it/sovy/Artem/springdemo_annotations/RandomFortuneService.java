package it.sovy.Artem.springdemo_annotations;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{

    // create an array of strings
    private String[] data = {
            "Beware of the wolf in sheep's clothing",
            "Diligence is the mother of good luck",
            "The journey is the reward"
    };

    // create a random number generator
    private Random rnd = new Random();

    @Override
    public String getFortune() {
        return data[rnd.nextInt(data.length)];
    }
}
