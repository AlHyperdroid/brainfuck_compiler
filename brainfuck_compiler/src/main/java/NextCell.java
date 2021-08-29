public class NextCell implements ICommand {
    @Override
    public void execute(Memory memory) {
        memory.nextCell();
    }
}
