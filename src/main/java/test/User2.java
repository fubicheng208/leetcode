package test;

public class User2 extends User {
    String name2;

    User2() {
        super();
    }

    User2(String name, String name2) {
        super(name);
        this.name2 = name2;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                "name2='" + name2 + '\'' +
                '}';
    }
}
