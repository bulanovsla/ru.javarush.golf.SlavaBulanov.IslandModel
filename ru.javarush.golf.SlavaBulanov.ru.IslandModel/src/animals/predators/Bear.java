package animals.predators;

import animals.herbivores.*;
import island.Coordinate;
import island.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bear extends Predator {

        {
            probability.put(Rabbit.class, 70);
            probability.put(Mouse.class, 90);
            probability.put(Duck.class, 60);
            probability.put(Caterpillar.class, 40);
        }
    private static final int MAX_COUNT_ON_LOCATION = 5;

    public Bear (Coordinate coordinate) {

        super(500, 80, 2, coordinate);
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
