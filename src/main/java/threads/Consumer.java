package threads;

/**
 * @author fubic
 * @date 2020-12-24
 */
public class Consumer extends Thread{
    private MyService myService;
    public Consumer(MyService service){
        super("消费者");
        this.myService = service;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            myService.get();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
