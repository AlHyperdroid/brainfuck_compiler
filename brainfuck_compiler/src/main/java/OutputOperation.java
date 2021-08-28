public class OutputOperation implements ICommand{
    @Override
    public void execute(Memory memory) {
        memory.output();
    }
}
