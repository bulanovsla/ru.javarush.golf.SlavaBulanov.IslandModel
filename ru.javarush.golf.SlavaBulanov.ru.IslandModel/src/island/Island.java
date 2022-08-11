package island;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Island {
    private static final int LINES = 100;
    private static final int COLUMNS = 20;
    Location[][] locations = new Location[LINES][COLUMNS];
    AnimalsFactory factory = new AnimalsFactoryImpl();
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);
    CountDownLatch lock = new CountDownLatch(3);

    private void runPredators() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                int finalI = i;
                int finalJ = j;
                executor.scheduleAtFixedRate(() -> {
                    Location currentLocation = locations[finalI][finalJ];
                    currentLocation.calculatePredators();
                    lock.countDown();
                }, 1000, 2000, TimeUnit.MILLISECONDS);
            }
        }
    }

    private void runHerbivores() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                int finalI = i;
                int finalJ = j;
                executor.scheduleAtFixedRate(() -> {
                    Location currentLocation = locations[finalI][finalJ];
                    currentLocation.calculateHerbivores();
                    lock.countDown();
                }, 500, 2000, TimeUnit.MILLISECONDS);
            }
        }
    }

    private void runPlants() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                int finalI = i;
                int finalJ = j;
                executor.scheduleAtFixedRate(() -> {
                    Location currentLocation = locations[finalI][finalJ];
                    currentLocation.calculatePlants();
                    lock.countDown();
                }, 0, 2000, TimeUnit.MILLISECONDS);
            }
        }
    }

    public void execute() throws InterruptedException {
        runPlants();
        runHerbivores();
        runPredators();
        printStatistics();
    }

    public void initialize() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = new Location(locations, factory, new Coordinate(i, j));
            }
        }
    }

    public void printStatistics() {
        executor.scheduleAtFixedRate(() -> {
            try {
                lock.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < locations.length; i++) {
                for (int j = 0; j < locations[i].length; j++) {
                    System.out.print(locations[i][j]);
                }
                System.out.println("=======================================");
            }
            lock = new CountDownLatch(LINES * COLUMNS * 3);
        }, 0, 1, TimeUnit.MILLISECONDS);
    }
}
