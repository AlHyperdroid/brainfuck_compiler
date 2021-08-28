import java.util.ArrayList;
import java.util.List;

public class Compiler {
    public List<ICommand> interpreter(String sourceCode) {
        List<ICommand> innerLoopCommands = new ArrayList<>();
        int index = 0;
        int firstBracketIndex = 0;
        char[] arraySourceCode = sourceCode.toCharArray();

        for (int i = 0; i < sourceCode.length(); i++) {
            if (arraySourceCode[i] == '[') {
                if (index == 0)
                    firstBracketIndex = i;
                index++;
            } else if (arraySourceCode[i] == ']') {
                index--;
                if (index == 0) {
                    String loopInput = sourceCode.substring(firstBracketIndex + 1, i);
                    innerLoopCommands.add(new Loop(interpreter(loopInput)));
                }
            } else if (index == 0) {
                innerLoopCommands.add(getNecessaryOperation(arraySourceCode[i]));
            }

        }
        return innerLoopCommands;
    }

    private ICommand getNecessaryOperation(Character character) {
        return switch (character) {
            case '+' -> new Increment();
            case '-' -> new Decrement();
            case '>' -> new NextCell();
            case '<' -> new PreviousCell();
            case '.' -> new OutputOperation();
            default -> new InvalidOperation();
        };
    }
}

