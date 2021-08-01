import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BFTest {
    ICommand cmp = new Compiler();
    String fullCode = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.\n" +
            "------.--------.>+.>.";

    @Test
    void compileHello() {
        String result = cmp.compiler(fullCode);
        assertEquals("Hello World!\n", result);
    }

    @Test
    void checkInterpreter() {
        List<Syntax> list = new ArrayList<Syntax>();
        list.add(Syntax.INC);
        list.add(Syntax.INC);
        list.add(Syntax.INC);
        list.add(Syntax.INC);
        list.add(Syntax.INC);
        Assertions.assertIterableEquals(list, Interpreter.adapt("+++++"));

    }
    @Test
    void checkInterpreterTwo() {
        Assertions.assertEquals("[INC, FIRST_BRACKET, DEC, LAST_BRACKET, INC, NEXT, NEXT, OUT]", Interpreter.adapt("+[-]+>>.").toString());
    }
}
