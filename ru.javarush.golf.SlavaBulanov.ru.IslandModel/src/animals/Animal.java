package animals;

import island.Coordinate;
import island.Direction;
import island.Location;

import java.util.Objects;
import java.util.UUID;

public abstract class Animal {
    public double weight;
    protected double maxFoodKg;
    protected double currentFoodKg;
    private String id;
    protected int maxMoves;

    protected Coordinate coordinate;

    public Animal(double weight, double maxFoodKg, int maxMoves, Coordinate coordinate) {
        this.id = UUID.randomUUID().toString();
        this.weight = weight;
        this.maxFoodKg = maxFoodKg;
        this.maxMoves = maxMoves;
        this.coordinate = coordinate;
    }

    private void moveToAnotherLocation(Location[][] locations, Coordinate newCoordinate) {
        Location currentLocation = locations[coordinate.getLine()][coordinate.getColumn()];
        try {
            Location newLocation = locations[newCoordinate.getLine()][newCoordinate.getColumn()];
            this.coordinate = newCoordinate;
            moveToAnotherLocation(currentLocation, newLocation);
        } catch (Exception e) {
            //нельзя сделать ход
        }
    }

    protected abstract void moveToAnotherLocation(Location currentLocation, Location newLocation);

    public void moveToAnotherLocation(Location[][] locations) {
        int moves = 1 + (int) (Math.random() * maxMoves);
        int order = (int) (Math.random() * 3);
        Direction direction = Direction.getDirection(order);
        switch (direction) {
            case UP:
                moveToAnotherLocation(locations, new Coordinate(coordinate.getLine() - moves, coordinate.getColumn()));
                break;

            case DOWN:
                moveToAnotherLocation(locations, new Coordinate(coordinate.getLine() + moves, coordinate.getColumn()));
                break;

            case LEFT:
                moveToAnotherLocation(locations, new Coordinate(coordinate.getLine(), coordinate.getColumn() - moves));
                break;

            case RIGHT:
                moveToAnotherLocation(locations, new Coordinate(coordinate.getLine(), coordinate.getColumn() + moves));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type=" + getClass().getSimpleName() + " " +
                "currentFoodKg=" + currentFoodKg +
                '}';
    }
}
