package animals.predators;

import animals.herbivores.*;
import island.Coordinate;

import java.util.List;

public class Eagle extends Predator {

    {
        probability.put(Rabbit.class, 90);
        probability.put(Mouse.class, 90);
        probability.put(Duck.class, 80);
    }

    private static final int MAX_COUNT_ON_LOCATION = 20;

    public Eagle(Coordinate coordinate) {
        super(6,1,3, coordinate);
    }
    @Override
    public void breed(List<Predator> predators) {
        List<Eagle> eagles = predators.stream().filter(Eagle.class::isInstance)
                .map(Eagle.class::cast).toList();

        if (!eagles.isEmpty() && eagles.size() < MAX_COUNT_ON_LOCATION) {
            predators.add(new Eagle(coordinate));
        }
    }
}
