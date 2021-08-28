public class Memory {

    private char[] memory_size = new char[10000];
    private int current;
    private final StringBuilder word = new StringBuilder();

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
        word.append(letter);
    }
    public int getCurrentCell() { return memory_size[current];}
}
