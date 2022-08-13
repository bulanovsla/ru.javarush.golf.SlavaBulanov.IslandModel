package animals.predators;

import animals.herbivores.*;
import island.Coordinate;

import java.util.List;

public class Fox extends Predator {

    {
        probability.put(Rabbit.class, 70);
        probability.put(Mouse.class, 90);
        probability.put(Duck.class, 60);
        probability.put(Caterpillar.class, 40);
    }

    private static final int MAX_COUNT_ON_LOCATION = 30;
    private static final double WEIGHT = 8;
    private static final double MAX_FOOD_KG = 2;
    private static final int MAX_MOVES = 2;

    public Fox(Coordinate coordinate) {
        super(WEIGHT, MAX_FOOD_KG, MAX_MOVES, coordinate);
    }

    @Override
    public void breed(List<Predator> predators) {
        List<Fox> foxes = predators.stream().filter(Fox.class::isInstance)
                .map(Fox.class::cast).toList();

        if (!foxes.isEmpty() && foxes.size() < MAX_COUNT_ON_LOCATION) {
            predators.add(new Fox(coordinate));
        }
    }
}

