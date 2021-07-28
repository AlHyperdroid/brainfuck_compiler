import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BFTest {

    ICommand cmp = new Compiler();
    String fullCode = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.\n" +
            "------.--------.>+.>.";

    @Test
    void compileHello() {
        String result = cmp.compiler(fullCode);
        assertEquals("Hello World!", result);
    }

    @Test
    void checkInterpreter() {
        assertEquals("INC, INC, INC, INC, INC", Interpreter.adapt("+++++"));

    }
    @Test
    void checkInterpreterTwo() {
        assertEquals("INC, FIRST_BRACKET, DEC, LAST_BRACKET, INC, NEXT, NEXT, OUT", Interpreter.adapt("+[-]+>>."));
    }
}
