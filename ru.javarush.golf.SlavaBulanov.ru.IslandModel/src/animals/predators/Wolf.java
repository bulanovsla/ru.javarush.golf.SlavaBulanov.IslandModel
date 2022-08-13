package animals.predators;

import animals.Animal;
import animals.herbivores.*;
import island.Coordinate;
import island.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Wolf extends Predator {

    {
        probability.put(Horse.class, 10);
        probability.put(Deer.class, 15);
        probability.put(Rabbit.class, 60);
        probability.put(Mouse.class, 80);
        probability.put(Goat.class, 60);
        probability.put(Sheep.class, 70);
        probability.put(Boar.class, 15);
        probability.put(Buffalo.class, 10);
        probability.put(Duck.class, 40);
    }

    private static final int MAX_COUNT_ON_LOCATION = 30;
    private static final double WEIGHT = 50;
    private static final double MAX_FOOD_KG = 8;
    private static final int MAX_MOVES = 8;

    public Wolf(Coordinate coordinate) {
        super(WEIGHT, MAX_FOOD_KG, MAX_MOVES, coordinate);
    }

    @Override
    public void breed(List<Predator> predators) {
        List<Wolf> wolves = predators.stream().filter(Wolf.class::isInstance)
                .map(Wolf.class::cast).toList();

        if (!wolves.isEmpty() && wolves.size() < MAX_COUNT_ON_LOCATION) {
            predators.add(new Wolf(coordinate));
        }
    }
}
