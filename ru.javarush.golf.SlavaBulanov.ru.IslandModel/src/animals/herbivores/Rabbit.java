package animals.herbivores;

import animals.predators.Wolf;
import island.Coordinate;

import java.util.List;

public class Rabbit extends Herbivore {
    private static final int MAX_COUNT_ON_LOCATION = 150;
    public Rabbit(Coordinate coordinate) {
        super(2, 0.45, 2, coordinate);
    }

    @Override
    public void breed(List<Herbivore> herbivores) {
        List<Rabbit> rabbits = herbivores.stream().filter(Rabbit.class::isInstance)
                .map(Rabbit.class::cast).toList();

        if (!rabbits.isEmpty() && rabbits.size() < MAX_COUNT_ON_LOCATION) {
            herbivores.add(new Rabbit(coordinate));
        }
    }
}
