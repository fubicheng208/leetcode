package JUC.consumer_provider;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;

    //生产者方法
    public void set() {
        try {
            lock.lock();
            while (hasValue) {
                System.out.println("已经有产品，不能生产");
                //释放锁，尾插到等待队列中，并唤醒同步队列中的下一个节点
                condition.await();
            }
            System.out.println("生产产品");
            hasValue = true;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //消费者方法
    public void get() {
        try {
            lock.lock();
            while (!hasValue) {
                System.out.println("现在还没有物品，释放锁，进入等待队列");
                condition.await();
            }
            System.out.println("消费物品");
            hasValue = false;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
