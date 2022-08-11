package animals.herbivores;

import island.Coordinate;

import java.util.List;

public class Goat extends Herbivore {
    private static final int MAX_COUNT_ON_LOCATION = 140;

    public Goat(Coordinate coordinate) {
        super(60, 10, 3, coordinate);
    }

    @Override
    public void breed(List<Herbivore> herbivores) {
        List<Goat> goats = herbivores.stream().filter(Goat.class::isInstance)
                .map(Goat.class::cast).toList();

        if (!goats.isEmpty() && goats.size() < MAX_COUNT_ON_LOCATION) {
            herbivores.add(new Goat(coordinate));
        }
    }
}
