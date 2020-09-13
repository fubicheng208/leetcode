package design_pattern;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

//饿汉模式
public class EagerSingleton {
    private static EagerSingleton singleton = new EagerSingleton();
    private EagerSingleton(){

    }

    public static EagerSingleton getInstance(){
        return singleton;
    }

}
