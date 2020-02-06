import com.manhpd.*;

public class Application {

    public static void main(String[] args) {
        Mediator1 mediator = new Mediator1();

        Colleague1 c1 = new Colleague1(mediator);
        Colleague2 c2 = new Colleague2(mediator);
        mediator.setColleagues(c1, c2);

        System.out.println("Changing state of Colleague1 ...");
        c1.setState("Hello world1");

        System.out.println("Changing state of Colleague2 ...");
        c2.setState("Hello world2");
    }

}
