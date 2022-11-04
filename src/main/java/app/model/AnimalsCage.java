package app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AnimalsCage {

    public AnimalsCage() {
        this(null);
    }

    public AnimalsCage(Animal animal) {
        this.animal = animal;
    }

    @Autowired
    @Qualifier("dog")
    private Animal animal;

    @Autowired
    private Timer timer;

    public void whatAnimalSay() {
        System.out.println("Say:");
        System.out.println(animal.toString());
        System.out.println("At:");
        System.out.println(new Timer().getTime());
        System.out.println("________________________");
    }

    @Bean("dog")
    public Dog getDog() {
        return new Dog();
    }

    @Bean()
    public Timer getTimer() {
        Timer timer1;
        timer1 = timer;
        return timer1;
    }
}
