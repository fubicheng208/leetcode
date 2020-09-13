package design_pattern;

import com.sun.org.apache.xalan.internal.xsltc.dom.SingletonIterator;

//懒汉模式
public class LazySingleton {
    private static LazySingleton lazySingleton;

    private LazySingleton(){}

    //多线程环境下，会出现线程安全问题，因此需要加锁
    public synchronized static LazySingleton getInstance(){
        if(lazySingleton != null){
        }else{
            //...创建前的准备工作
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
