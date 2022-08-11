package animals.herbivores;

import island.Coordinate;

import java.util.List;

public class Mouse extends Herbivore {
    private static final int MAX_COUNT_ON_LOCATION = 500;

    public Mouse(Coordinate coordinate) {
        super(0.05, 0.01, 1, coordinate);
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
