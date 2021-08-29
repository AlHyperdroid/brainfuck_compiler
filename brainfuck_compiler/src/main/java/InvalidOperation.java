public class InvalidOperation implements ICommand {

    @Override
    public void execute(Memory memory) {
        System.out.println("Invalid command");
    }
}
