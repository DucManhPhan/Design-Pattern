import com.manhpd.ConcreteObserver;
import com.manhpd.ConcreteSubject;
import com.manhpd.IObserver;
import com.manhpd.ISubject;

public class Application {

    public static void main(String[] args) {
        ISubject subject = new ConcreteSubject();

        IObserver observer1 = new ConcreteObserver("john-wick.gmail.com");
        IObserver observer2 = new ConcreteObserver("selena-william.yahoo.com");
        IObserver observer3 = new ConcreteObserver("bad-boy.zalo.com");

        // register some observers
        subject.register(observer1);
        subject.register(observer2);
        subject.register(observer3);

        // save subject for each observer
        observer1.saveSubject(subject);
        observer2.saveSubject(subject);
        observer3.saveSubject(subject);

        subject.changeState("Fuck you!!!");
    }

}
