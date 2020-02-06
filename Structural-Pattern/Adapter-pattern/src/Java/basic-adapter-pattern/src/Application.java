import com.manhpd.Adaptee;
import com.manhpd.ITarget;
import com.manhpd.ObjectAdapter;

public class Application {

    public static void main(String[] args) {
        ITarget target = new ObjectAdapter(new Adaptee());
        System.out.println(target.operation());
    }

}
