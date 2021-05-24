package JUC.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    //闭锁
    //主线程的闭锁
    private static CountDownLatch main_cdl = new CountDownLatch(1);
    private static CountDownLatch sub_cdl = new CountDownLatch(5);

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            new Thread(new SubThread("Thread" + i)).start();
        }
        try {
            Thread.sleep(1000);
            System.out.println("主线程下命令说可以运行");
            main_cdl.countDown();
            System.out.println("等待子线程全部执行完毕");
            sub_cdl.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("主线程在子线程全部结束后结束");

    }

    static class SubThread implements Runnable {
        String name;

        public SubThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                //等待主线程启动子线程
                System.out.println("线程" + name + " is waiting");
                main_cdl.await();
                System.out.println("线程" + name + " is running");
                Thread.sleep(1000);
                System.out.println("线程" + name + " is finished");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //子线程计数器减一
                sub_cdl.countDown();
            }
        }
    }
}
