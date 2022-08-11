package animals.herbivores;

import island.Coordinate;

import java.util.List;

public class Deer extends Herbivore {
    private static final int MAX_COUNT_ON_LOCATION = 20;

    public Deer(Coordinate coordinate) {
        super(300, 50, 4, coordinate);
    }

    @Override
    public void breed(List<Herbivore> herbivores) {
        List<Deer> deer = herbivores.stream().filter(Deer.class::isInstance)
                .map(Deer.class::cast).toList();

        if (!deer.isEmpty() && deer.size() < MAX_COUNT_ON_LOCATION) {
            herbivores.add(new Deer(coordinate));
        }
    }
}
