public class Compiler implements ICommand {

    public String compiler(String fullCode) {
        Interpreter interpreter = new Interpreter(Interpreter.adapt(fullCode));
        interpreter.compile();
        return fullCode;
    }
}


