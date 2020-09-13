package JUC.consumer_provider;

public class Test {
    public static void main(String[] args) {
        MyService myService = new MyService();
        MyConsumerThread myConsumerThread = new MyConsumerThread(myService);
        MyProviderThread myProviderThread = new MyProviderThread(myService);
        myConsumerThread.start();
        myProviderThread.start();
    }
}
