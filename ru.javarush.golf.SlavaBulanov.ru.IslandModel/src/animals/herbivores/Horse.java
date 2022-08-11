package animals.herbivores;

import island.Coordinate;

import java.util.List;

public class Horse extends Herbivore {
    private static final int MAX_COUNT_ON_LOCATION = 20;

    public Horse(Coordinate coordinate) {
        super(400, 60, 4, coordinate);
    }

    @Override
    public void breed(List<Herbivore> herbivores) {
        List<Horse> horses = herbivores.stream().filter(Horse.class::isInstance)
                .map(Horse.class::cast).toList();

        if (!horses.isEmpty() && horses.size() < MAX_COUNT_ON_LOCATION) {
            herbivores.add(new Horse(coordinate));
        }
    }
}
