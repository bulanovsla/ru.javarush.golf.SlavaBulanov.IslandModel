package animals.herbivores;

import animals.Animal;
import island.Coordinate;
import island.Location;
import plants.Plant;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Herbivore extends Animal {

    public Herbivore(double weight, double maxFoodKg, int maxMoves, Coordinate coordinate) {
        super(weight, maxFoodKg, maxMoves, coordinate);
    }

    public void eat(Location currentLocation) {
        List<Plant> plants = currentLocation.getPlants();
        if (!plants.isEmpty() && currentFoodKg < maxFoodKg) {
            Plant plant = plants.get(0);
            currentFoodKg += plant.WEIGHT;
            currentLocation.getPlants().remove(plant);
        }
    }

    public abstract void breed(List<Herbivore> herbivores);

    @Override
    protected void moveToAnotherLocation(Location currentLocation, Location newLocation) {
        currentLocation.getHerbivores().remove(this);
        newLocation.getHerbivores().add(this);
    }
}