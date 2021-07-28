import java.util.ArrayList;
import java.util.List;

public class Interpreter {
    private static final int MEM = 10000;
    private final char[] memory_size;
    private final List<Syntax> syntax;
    private int index, current, count;

    Interpreter(List<Syntax> syntax) {
        memory_size = new char[MEM];
        this.syntax = syntax;
    }

    public static List<Syntax> adapt(String source) {
        List<Syntax> syntax = new ArrayList<>();
        for (int i = 0; i < source.length(); ++i) {
            Syntax synt = switch (source.charAt(i)) {
                case '>' -> Syntax.NEXT;
                case '<' -> Syntax.PREV;
                case '+' -> Syntax.INC;
                case '-' -> Syntax.DEC;
                case '.' -> Syntax.OUT;
                case '[' -> Syntax.FIRST_BRACKET;
                case ']' -> Syntax.LAST_BRACKET;
                default -> null;
            };
            if (synt == null)
                continue;
            syntax.add(synt);
        }
        return syntax;
    }

    private void nextCell() { current++; }

    private void previousCell() { current--; }

    private void increment() { memory_size[current]++; }

    private void decrement() { memory_size[current]--; }

    private void output() { System.out.print(memory_size[current]); }

    private void firstBracket() {
        int loop = count + 1;
        while (count != loop) {
            index--;
            checkArray();
        }
    }

    private void lastBracket() {
        int loop = count - 1;
        while (count != loop) {
            index++;
            checkArray();
        }
    }

    private void checkArray() {
        switch (syntax.get(index)) {
            case FIRST_BRACKET -> count++;
            case LAST_BRACKET -> count--;
        }
    }
    public void compile() {

        for (index = 0; index < syntax.size(); index++) {
            switch (syntax.get(index)) {
                case NEXT -> nextCell();
                case PREV -> previousCell();
                case INC -> increment();
                case DEC -> decrement();
                case OUT -> output();
                case FIRST_BRACKET -> {
                    count++;
                    if (memory_size[current] == (char) 0) {
                        lastBracket();
                    }
                }
                case LAST_BRACKET -> {
                    count--;
                    if (memory_size[current] != (char) 0) {
                        firstBracket();
                    }
                }
            }
        }
    }
}


