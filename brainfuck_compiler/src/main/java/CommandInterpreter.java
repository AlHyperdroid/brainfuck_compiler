import java.util.*;

public class CommandInterpreter {
    private Map<Character, ICommand> innerCommandsMap;

    public CommandInterpreter() {
        innerLoopCommandsMap();
    }

    public List<ICommand> interpreter(String brainFuckCode) {
        Deque<List<ICommand>> stack = new ArrayDeque<>();
        stack.push(new ArrayList<>());


        for (char character : brainFuckCode.toCharArray()) {

            ICommand command = innerCommandsMap.get(character);

            if (command == null) loopCommands(stack, character);

            if (command != null) stack.peek().add(command);

        }
        return stack.pop();
    }

    private void loopCommands(Deque<List<ICommand>> stack, char character) {

        if (character == '[') {
            stack.push(new ArrayList<>());
        }

        if (character == ']') {
            Loop loop = new Loop(stack.pop());
            stack.peek().add(loop);
        }
    }

    private void innerLoopCommandsMap() {
        innerCommandsMap = new HashMap<>();
        innerCommandsMap.put('+', new Increment());
        innerCommandsMap.put('-', new Decrement());
        innerCommandsMap.put('.', new OutputOperation());
        innerCommandsMap.put('>', new NextCell());
        innerCommandsMap.put('<', new PreviousCell());
    }
}

