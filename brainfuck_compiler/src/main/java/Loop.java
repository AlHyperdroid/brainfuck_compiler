import java.util.List;

public class Loop implements ICommand {
    private final List<ICommand> innerCommands;

    public Loop(List<ICommand> innerCommands) {
        this.innerCommands = innerCommands;
    }

    public void execute(Memory memory){
    while (memory.getCurrentCell() > 0){
    for (ICommand command : innerCommands){
        command.execute(memory);
    }

}

    }
}
