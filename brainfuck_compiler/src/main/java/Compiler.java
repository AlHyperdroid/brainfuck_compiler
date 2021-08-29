import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class Compiler {
    static String run(List<ICommand> innerLoopCommands) {
        Memory memory = new Memory();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        System.out.flush();

        for (ICommand command : innerLoopCommands) {
            command.execute(memory);
        }

        return byteArrayOutputStream.toString();

    }
}
