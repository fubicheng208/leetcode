package threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fubic
 * @date 2020-12-24
 */
public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;
    public void set(){
        try{
            lock.lock();
            while(hasValue){
                System.out.println("存在商品，生产者等待");
                condition.await();
            }
            System.out.println("生产了商品");
            hasValue = true;
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void get(){
        try{
            lock.lock();
            while(!hasValue){
                System.out.println("不存在商品，消费者等待");
                condition.await();
            }
            System.out.println("消费了商品");
            hasValue = false;
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
