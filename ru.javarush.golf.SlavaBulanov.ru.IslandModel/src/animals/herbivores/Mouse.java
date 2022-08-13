package animals.herbivores;

import island.Coordinate;

import java.util.List;

public class Mouse extends Herbivore {
    private static final int MAX_COUNT_ON_LOCATION = 500;
    private static final double WEIGHT = 0.05;
    private static final double MAX_FOOD_KG = 0.01;
    private static final int MAX_MOVES = 1;

    public Mouse(Coordinate coordinate) {
        super(WEIGHT, MAX_FOOD_KG, MAX_MOVES, coordinate);
    }

    @Override
    public void breed(List<Herbivore> herbivores) {
        List<Mouse> mice = herbivores.stream().filter(Mouse.class::isInstance)
                .map(Mouse.class::cast).toList();

        if (!mice.isEmpty() && mice.size() < MAX_COUNT_ON_LOCATION) {
            herbivores.add(new Mouse(coordinate));
        }
    }
}
