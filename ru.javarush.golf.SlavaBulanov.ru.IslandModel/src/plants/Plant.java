package plants;

import animals.predators.Predator;
import animals.predators.Wolf;

import java.util.List;

public class Plant {
    public static final int WEIGHT = 1;
    public static final int MAX_IN_LOCATION = 200;

    public void reproduce(List<Plant> plants) {

        if (plants.size() < MAX_IN_LOCATION) {
            plants.add(new Plant());
        }
    }

    @Override
    public String toString() {
        return "Plant{}";
    }
}
