package island;

import animals.herbivores.Herbivore;
import animals.predators.Predator;
import plants.Plant;

public interface AnimalsFactory {
    Predator createPredator(Coordinate coordinate);
    Herbivore createHerbivore(Coordinate coordinate);
    Plant createPlant();
}
