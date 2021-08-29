public class Memory {

    private final char[] memory_size = new char[10000];
    private int current;


    public void nextCell() {
        current++;
    }

    public void previousCell() {
        current--;
    }

    public void increment() {
        memory_size[current]++;
    }

    public void decrement() {
        memory_size[current]--;
    }

    public void output() {
        char letter = memory_size[current];
        System.out.print(letter);
    }

    public int getCurrentCell() {
        return memory_size[current];
    }
}
