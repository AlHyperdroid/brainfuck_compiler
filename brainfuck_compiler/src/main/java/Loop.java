import java.util.List;

public class Loop implements ICommand {
    private final List<ICommand> innerLoopCommands;

    public Loop(List<ICommand> innerLoopCommands) {
        this.innerLoopCommands = innerLoopCommands;
    }

    public void execute(Memory memory) {
        while (memory.getCurrentCell() > 0) {
            for (ICommand command : innerLoopCommands) {
                command.execute(memory);
            }
        }
    }
}
