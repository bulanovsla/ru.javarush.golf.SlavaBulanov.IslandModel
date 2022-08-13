package animals.herbivores;

import island.Coordinate;

import java.util.List;

public class Caterpillar extends Herbivore {
    private static final int MAX_COUNT_ON_LOCATION = 1000;
    private static final double WEIGHT = 0.01;
    private static final double MAX_FOOD_KG = 0;
    private static final int MAX_MOVES = 0;

    public Caterpillar(Coordinate coordinate) {
        super(WEIGHT, MAX_FOOD_KG, MAX_MOVES, coordinate);
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
