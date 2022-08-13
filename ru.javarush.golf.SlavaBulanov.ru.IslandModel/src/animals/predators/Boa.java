package animals.predators;

import animals.herbivores.*;
import island.Coordinate;
import island.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Boa extends Predator {

    {
        probability.put(Rabbit.class, 20);
        probability.put(Mouse.class, 40);
        probability.put(Duck.class, 10);
    }

    private static final int MAX_COUNT_ON_LOCATION = 30;
    private static final double WEIGHT = 15;
    private static final double MAX_FOOD_KG = 3;
    private static final int MAX_MOVES = 1;

    public Boa(Coordinate coordinate) {
        super(WEIGHT, MAX_FOOD_KG, MAX_MOVES, coordinate);
    }

    @Override
    public void breed(List<Predator> predators) {
        List<Boa> boas = predators.stream().filter(Boa.class::isInstance)
                .map(Boa.class::cast).toList();

        if (!boas.isEmpty() && boas.size() < MAX_COUNT_ON_LOCATION) {
            predators.add(new Boa(coordinate));
        }
    }
}
