import com.manhpd.Component2;
import com.manhpd.Decorator1;
import com.manhpd.Decorator2;
import com.manhpd.IComponent;

public class Application {

    public static void main(String[] args) {
        IComponent component = new Component2();
        component.doOperation();

        // add new functionality
        IComponent decorator_new_functionality = new Decorator1(new Decorator2(component));
        decorator_new_functionality.doOperation();
    }

}
