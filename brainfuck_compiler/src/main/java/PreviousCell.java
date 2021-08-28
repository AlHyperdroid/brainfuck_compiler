public class PreviousCell implements ICommand{
    @Override
    public void execute(Memory memory) {
        memory.previousCell();
    }
}
