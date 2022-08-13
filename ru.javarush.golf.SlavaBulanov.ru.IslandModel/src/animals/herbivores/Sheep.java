package animals.herbivores;

import island.Coordinate;

import java.util.List;

public class Sheep extends Herbivore {
    private static final int MAX_COUNT_ON_LOCATION = 140;
    private static final double WEIGHT = 70;
    private static final double MAX_FOOD_KG = 15;
    private static final int MAX_MOVES = 3;

    public Sheep(Coordinate coordinate) {
        super(WEIGHT, MAX_FOOD_KG, MAX_MOVES, coordinate);
    }

    @Override
    public void breed(List<Herbivore> herbivores) {
        List<Sheep> sheeps = herbivores.stream().filter(Sheep.class::isInstance)
                .map(Sheep.class::cast).toList();

        if (!sheeps.isEmpty() && sheeps.size() < MAX_COUNT_ON_LOCATION) {
            herbivores.add(new Sheep(coordinate));
        }
    }
}
