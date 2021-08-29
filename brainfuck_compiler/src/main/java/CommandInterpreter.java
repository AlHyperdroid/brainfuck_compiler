import java.util.ArrayList;
import java.util.List;

public class CommandInterpreter {
    public List<ICommand> interpreter(String brainFuckCode) {
        List<ICommand> innerLoopCommands = new ArrayList<>();
        int index = 0;
        int firstBracketIndex = 0;
        char[] arrayBrainFuckCode = brainFuckCode.toCharArray();

        for (int i = 0; i < brainFuckCode.length(); i++) {
            if (arrayBrainFuckCode[i] == '[') {
                if (index == 0)
                    firstBracketIndex = i;
                index++;
            } else if (arrayBrainFuckCode[i] == ']') {
                index--;
                if (index == 0) {
                    String loopInput = brainFuckCode.substring(firstBracketIndex + 1, i);
                    innerLoopCommands.add(new Loop(interpreter(loopInput)));
                }
            } else if (index == 0) {
                innerLoopCommands.add(getNecessaryOperation(arrayBrainFuckCode[i]));
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

