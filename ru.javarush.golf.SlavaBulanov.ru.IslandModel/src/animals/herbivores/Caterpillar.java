package animals.herbivores;

import island.Coordinate;

import java.util.List;

public class Caterpillar extends Herbivore {
    private static final int MAX_COUNT_ON_LOCATION = 1000;
    public Caterpillar(Coordinate coordinate) {
        super(0.01, 0, 0, coordinate);
    }

    @Override
    public void breed(List<Herbivore> herbivores) {
        List<Caterpillar> caterpillars = herbivores.stream()
                .filter(Caterpillar.class::isInstance)
                .map(Caterpillar.class::cast).toList();

        if (!caterpillars.isEmpty() && caterpillars.size() < MAX_COUNT_ON_LOCATION) {
            herbivores.add(new Caterpillar(coordinate));
        }
    }
}
