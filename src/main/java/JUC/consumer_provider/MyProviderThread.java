package JUC.consumer_provider;

public class MyProviderThread extends Thread {
    private MyService myService;

    public MyProviderThread(MyService myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            myService.set();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
