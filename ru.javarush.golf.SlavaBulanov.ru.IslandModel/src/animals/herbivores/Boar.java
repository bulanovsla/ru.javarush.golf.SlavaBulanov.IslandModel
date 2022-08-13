package animals.herbivores;

import island.Coordinate;

import java.util.List;

public class Boar extends Herbivore {
    private static final int MAX_COUNT_ON_LOCATION = 50;
    private static final double WEIGHT = 400;
    private static final double MAX_FOOD_KG = 50;
    private static final int MAX_MOVES = 2;

    public Boar(Coordinate coordinate) {
        super(WEIGHT, MAX_FOOD_KG, MAX_MOVES, coordinate);
    }

    @Override
    public void breed(List<Herbivore> herbivores) {
        List<Boar> boars = herbivores.stream().filter(Boar.class::isInstance)
                .map(Boar.class::cast).toList();

        if (!boars.isEmpty() && boars.size() < MAX_COUNT_ON_LOCATION) {
            herbivores.add(new Boar(coordinate));
        }
    }
}
