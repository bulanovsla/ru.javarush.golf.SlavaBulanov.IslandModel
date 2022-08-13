package island;

import animals.herbivores.Herbivore;
import animals.predators.Predator;
import plants.Plant;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Location {

    Location[][] locations;
    AnimalsFactory factory;
    Coordinate coordinate;
    List<Herbivore> herbivores = new CopyOnWriteArrayList<>();
    List<Predator> predators = new CopyOnWriteArrayList<>();
    List<Plant> plants = new CopyOnWriteArrayList<>();

    public Location(Location[][] locations, AnimalsFactory factory, Coordinate coordinate) {
        this.locations = locations;
        this.factory = factory;
        this.coordinate = coordinate;
    }

    public List<Herbivore> getHerbivores() {
        return herbivores;
    }

    public List<Predator> getPredators() {
        return predators;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void calculatePredators() {
        for (int i = 0; i < 3; i++) {
            predators.add(factory.createPredator(coordinate));
        }
        for (int i = 0; i < predators.size(); i++) {
            Predator predator = predators.get(i);
            predator.eat(this);
            predator.breed(predators);
            predator.moveToAnotherLocation(locations);
        }
    }

    public void calculateHerbivores() {
        for (int i = 0; i < 3; i++) {
            herbivores.add(factory.createHerbivore(coordinate));
        }
        for (int i = 0; i < herbivores.size(); i++) {
            Herbivore herbivore = herbivores.get(i);
            herbivore.eat(this);
            herbivore.breed(herbivores);
            herbivore.moveToAnotherLocation(locations);
        }
    }

    public void calculatePlants() {
        for (int i = 0; i < 50; i++) {
            plants.add(factory.createPlant());
        }
        for (int i = 0; i < plants.size(); i++) {
            Plant plant = plants.get(i);
            plant.reproduce(plants);
        }
    }

    @Override
    public String toString() {
        return "Location: " + "[" + coordinate.getLine() + "]" + "[" + coordinate.getColumn() + "]" + "\n"
                + "Predators: " + Arrays.toString(predators.toArray()) + "\n"
                + "Herbivores: " + Arrays.toString(herbivores.toArray()) + "\n"
                + "Plants: " + Arrays.toString(plants.toArray());
    }
}
