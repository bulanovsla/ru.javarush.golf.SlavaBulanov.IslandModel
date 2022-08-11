package animals.herbivores;

import island.Coordinate;
import island.Location;
import plants.Plant;

import java.util.List;

public class Duck extends Herbivore {
    private static final int MAX_COUNT_ON_LOCATION = 200;

    public Duck(Coordinate coordinate) {
        super(1, 0.15, 4, coordinate);
    }

    @Override
    public void eat(Location currentLocation) {
        super.eat(currentLocation);
        List<Herbivore> herbivores = currentLocation.getHerbivores();
        List<Caterpillar> caterpillars = herbivores.stream()
                .filter(Caterpillar.class::isInstance)
                .map(Caterpillar.class::cast).toList();
        if (!caterpillars.isEmpty() && currentFoodKg < maxFoodKg) {
            Caterpillar caterpillar = caterpillars.get(0);
            currentFoodKg += caterpillar.weight;
            currentLocation.getHerbivores().remove(caterpillar);
        }
    }

    @Override
    public void breed(List<Herbivore> herbivores) {
        List<Duck> ducks = herbivores.stream().filter(Duck.class::isInstance)
                .map(Duck.class::cast).toList();

        if (!ducks.isEmpty() && ducks.size() < MAX_COUNT_ON_LOCATION) {
            herbivores.add(new Duck(coordinate));
        }
    }
}
