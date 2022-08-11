import island.Island;

public class Runner {
    public static void main(String[] args) {

        Island island = new Island();
        island.initialize();
        try {
            island.execute();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
