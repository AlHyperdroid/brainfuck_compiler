import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BFTest {
    String brainfuckCode = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
    CommandInterpreter commandInterpreter = new CommandInterpreter();
    Memory memory = new Memory();

    @Test
    void compileHello() {
        List<ICommand> innerLoopCommands = commandInterpreter.interpreter(brainfuckCode);
        String result = Compiler.run(innerLoopCommands);
        assertEquals("Hello World!\n", result);
    }

    @Test
    public void incrementTest() {
        memory.increment();
        memory.increment();
        memory.increment();

        int getDataOfCurrentCell = memory.getCurrentCell();
        assertEquals(3, getDataOfCurrentCell);
    }

    @Test
    public void incrementDecrementTest() {
        memory.increment();
        memory.decrement();
        memory.increment();
        memory.decrement();

        int getDataOfCurrentCell = memory.getCurrentCell();
        assertEquals(0, getDataOfCurrentCell);
    }
}