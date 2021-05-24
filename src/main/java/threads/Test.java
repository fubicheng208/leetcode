package threads;

import org.checkerframework.checker.units.qual.C;

/**
 * @author fubic
 * @date 2020-12-24
 */
public class Test {
    public static void main(String[] args) {
        MyService service = new MyService();
        Consumer consumer = new Consumer(service);
        Provider provider = new Provider(service);
        consumer.start();
        provider.start();
    }
}
