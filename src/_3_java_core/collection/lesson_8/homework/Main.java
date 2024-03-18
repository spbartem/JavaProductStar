package _3_java_core.collection.lesson_8.homework;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Stable<Horse> stableHorse = new Stable<>();
        Stable<Animal> stableAnimal = new Stable<>();

        Mustang mustang = new Mustang();
        System.out.println(stableHorse.addAnimal(mustang));

        Pony pony = new Pony();
        stableHorse.addAnimal(pony);

        List<Mustang> wildMustangs = new ArrayList<>();
        wildMustangs.add(new Mustang());
        wildMustangs.add(new Mustang());

        stableHorse.addAllAnimals(wildMustangs);

        System.out.println(stableHorse.countAnimals());
        System.out.println(stableAnimal.countAnimals());
        moveHorses(stableHorse, stableAnimal);
        System.out.println(stableHorse.countAnimals());
        System.out.println(stableAnimal.countAnimals());
    }

    public static <T> void moveHorses(Stable<? extends T> source, Stable<? super T> destination) {
        destination.addAllAnimals(source.getAllAnimals());
    }
}
