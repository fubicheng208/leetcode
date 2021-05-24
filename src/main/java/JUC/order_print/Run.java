package JUC.order_print;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Run {

    volatile private static int nextPrintWho = 1;
    private static ReentrantLock lock = new ReentrantLock();
    final private static Condition conditionA = lock.newCondition();
    final private static Condition conditionB = lock.newCondition();
    final private static Condition conditionC = lock.newCondition();

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (nextPrintWho != 1) {
                        conditionA.await();
                    }
                    System.out.println("Thread1");
                    nextPrintWho = 2;
                    conditionA.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (nextPrintWho != 2) {
                        conditionB.await();
                    }
                    System.out.println("Thread2");
                    nextPrintWho = 3;
                    conditionB.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread t3 = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (nextPrintWho != 3) {
                        conditionC.await();
                    }
                    System.out.println("Thread3");
                    nextPrintWho = 1;
                    conditionC.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread[] as = new Thread[5];
        Thread[] bs = new Thread[5];
        Thread[] cs = new Thread[5];
        for (int i = 0; i < 5; i++) {
            as[i] = new Thread(t1);
            bs[i] = new Thread(t2);
            cs[i] = new Thread(t3);

            as[i].start();
            bs[i].start();
            cs[i].start();
        }

    }
}
