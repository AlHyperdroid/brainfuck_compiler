public class Increment implements ICommand {
    @Override
    public void execute(Memory memory) {
        memory.increment();
    }
}
