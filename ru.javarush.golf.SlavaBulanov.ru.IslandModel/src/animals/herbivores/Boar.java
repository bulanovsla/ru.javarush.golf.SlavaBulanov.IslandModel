package animals.herbivores;

import island.Coordinate;

import java.util.List;

public class Boar extends Herbivore {
    private static final int MAX_COUNT_ON_LOCATION = 50;

    public Boar(Coordinate coordinate) {
        super(400, 50, 2, coordinate);
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
