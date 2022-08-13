package animals.herbivores;

import island.Coordinate;

import java.util.List;

public class Buffalo extends Herbivore {
    private static final int MAX_COUNT_ON_LOCATION = 10;
    private static final double WEIGHT = 700;
    private static final double MAX_FOOD_KG = 100;
    private static final int MAX_MOVES = 3;

    public Buffalo(Coordinate coordinate) {
        super(WEIGHT, MAX_FOOD_KG, MAX_MOVES, coordinate);
    }

    @Override
    public void breed(List<Herbivore> herbivores) {
        List<Buffalo> buffalo = herbivores.stream().filter(Buffalo.class::isInstance)
                .map(Buffalo.class::cast).toList();

        if (!buffalo.isEmpty() && buffalo.size() < MAX_COUNT_ON_LOCATION) {
            herbivores.add(new Buffalo(coordinate));
        }
    }
}
