package island;

import animals.herbivores.*;
import animals.predators.*;
import plants.Plant;

public class AnimalsFactoryImpl implements AnimalsFactory {
    @Override
    public Predator createPredator(Coordinate coordinate) {
        int random = 1 + (int) (Math.random() * 5);
        switch (random) {
            case 1:
                return new Wolf(coordinate);
            case 2:
                return new Fox(coordinate);
            case 3:
                return new Eagle(coordinate);
            case 4:
                return new Boa(coordinate);
            case 5:
                return new Bear(coordinate);
        }
        return null;
    }

    @Override
    public Herbivore createHerbivore(Coordinate coordinate) {
        int random = 1 + (int) (Math.random() * 10);
        switch (random) {
            case 1:
                return new Boar(coordinate);
            case 2:
                return new Buffalo(coordinate);
            case 3:
                return new Caterpillar(coordinate);
            case 4:
                return new Deer(coordinate);
            case 5:
                return new Duck(coordinate);
            case 6:
                return new Goat(coordinate);
            case 7:
                return new Horse(coordinate);
            case 8:
                return new Mouse(coordinate);
            case 9:
                return new Rabbit(coordinate);
            case 10:
                return new Sheep(coordinate);
        }
        return null;
    }

    @Override
    public Plant createPlant() {
        return new Plant();
    }

}
