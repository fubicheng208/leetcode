package test;

import java.util.List;

public class ListFanxing {
    List<User> list;
    String name;

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    //    public List<? extends User> getList() {
//        return list;
//    }
//
//    public void setList(List<? extends User> list) {
//        this.list = list;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
