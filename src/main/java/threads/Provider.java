package threads;

/**
 * @author fubic
 * @date 2020-12-24
 */
public class Provider extends Thread {
    private MyService myService;
    public Provider(MyService service){
        super("生产者");
        this.myService = service;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            myService.set();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
