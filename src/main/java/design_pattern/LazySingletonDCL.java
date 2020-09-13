package design_pattern;

public class LazySingletonDCL {
    private static LazySingletonDCL lazySingletonDCL;
    private LazySingletonDCL(){}

    //LazySingleton中锁住的是整个类，锁的粒度太大，效率不高；其实一些准备工作不必上锁
    public static LazySingletonDCL getInstance(){
        if(lazySingletonDCL != null){
            //...
        }else{
            //...做一些准备性工作
            synchronized (LazySingletonDCL.class){
                //有可能在做完准备工作，获得锁的时候，已经有别的线程创建了Singleton,因此需要再次检查
                if(lazySingletonDCL == null){
                    lazySingletonDCL = new LazySingletonDCL();
                }
            }
        }
        return lazySingletonDCL;
    }

}
