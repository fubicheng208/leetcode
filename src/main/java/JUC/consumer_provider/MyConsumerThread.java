package JUC.consumer_provider;

public class MyConsumerThread extends Thread{

    private MyService myService;

    public MyConsumerThread(MyService myService){
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i <  Integer.MAX_VALUE; i++) {
            myService.get();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
