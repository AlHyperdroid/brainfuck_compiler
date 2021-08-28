import java.util.List;

public class BFMain {
    public static void main(String[] args) {
        String brainfuckCode = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
        Memory memory = new Memory();
        Compiler compiler = new Compiler();
        List<ICommand> commands = compiler.interpreter(brainfuckCode);
        for (ICommand command : commands) {
            command.execute(memory);
        }
    }
}
