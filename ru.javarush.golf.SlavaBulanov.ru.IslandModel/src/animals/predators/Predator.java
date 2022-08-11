package animals.predators;

import animals.Animal;
import animals.herbivores.Herbivore;
import island.Coordinate;
import island.Location;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {

    protected Map<Class<? extends Herbivore>, Integer> probability = new HashMap<>();
    public Predator(double weight, double maxFoodKg, int maxMoves, Coordinate coordinate) {
        super(weight, maxFoodKg, maxMoves, coordinate);
    }
    public void eat(Location currentLocation) {
        Iterator<Herbivore> iter = currentLocation.getHerbivores().iterator();
        while(iter.hasNext()){
            Herbivore herbivore = iter.next();
            int probabilityValue = probability.get(herbivore.getClass());
            eat(herbivore, currentLocation, probabilityValue);
        }
    }
    private void eat(Herbivore herbivore, Location currentLocation, int probabilityValue) {
        int rand = ThreadLocalRandom.current().nextInt(0,100);
        if (rand <= probabilityValue && currentFoodKg < maxFoodKg) {
            currentFoodKg += herbivore.weight;
            currentLocation.getHerbivores().remove(herbivore);
        }
    }
    public abstract void breed(List<Predator> predators);
    @Override
    protected void moveToAnotherLocation(Location currentLocation, Location newLocation) {
        currentLocation.getPredators().remove(this);
        newLocation.getPredators().add(this);
    }
}