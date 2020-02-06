import com.manhpd.*;

import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        Expression example = new Addition(
                new Variable("x"),
                new Addition(new Constant(2), new Constant(3)));

        System.out.println("Expression is: " + PrettyPrinting.of(example));
        example = example.acceptVisitor(new ConstantFolding());
        System.out.println("Optimized expression is: " + PrettyPrinting.of(example));
        Map<String, Integer> variables = new HashMap<>();
        variables.put("x", 37);
        int result = Interpreter.eval(example, variables);
        System.out.println("result is: " + result);
    }

}
