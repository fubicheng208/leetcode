package JUC.order_print;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Foo {

    private volatile static int next = 1;
    private static ReentrantLock lock = new ReentrantLock();
    final private static Condition conditionA = lock.newCondition();
    final private static Condition conditionB = lock.newCondition();
    final private static Condition conditionC = lock.newCondition();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        try {
            lock.lock();
            while (next != 1)
                conditionA.await();

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            next = 2;
            conditionB.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        try {
            lock.lock();
            while (next != 2)
                conditionB.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            next = 3;
            conditionC.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        try {
            lock.lock();
            while (next != 3)
                conditionC.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            next = 1;
            conditionA.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
