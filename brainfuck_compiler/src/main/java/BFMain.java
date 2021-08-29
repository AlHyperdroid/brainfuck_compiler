import java.util.List;

public class BFMain {


    public static void main(String[] args) {
        String brainFuckCode = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
        CommandInterpreter compiler = new CommandInterpreter();
        List<ICommand> innerLoopCommands = compiler.interpreter(brainFuckCode);
        String result = Compiler.run(innerLoopCommands);
        System.out.println(result);

    }
}
