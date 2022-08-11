package island;

public enum Direction {
    UP, DOWN, LEFT, RIGHT;

    public static Direction getDirection(int order) {
        return Direction.values()[order];
    }
};
