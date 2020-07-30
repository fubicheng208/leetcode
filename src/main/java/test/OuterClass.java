package test;

import java.util.PriorityQueue;
import java.util.concurrent.locks.ReentrantLock;

public class OuterClass {
    int x = 1;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("hello");
        }
    };

    PriorityQueue pq;
}
