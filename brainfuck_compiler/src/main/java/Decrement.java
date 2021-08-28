public class Decrement implements ICommand{
    @Override
    public void execute(Memory memory) {
        memory.decrement();
    }
}
