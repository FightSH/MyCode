package org.example.singleton;

/**
 *
 */
public enum SingletonEnum {

    INSTANCE;

    private String name;

    SingletonEnum(){
        this.name = "i'm singleton";
    }

    public static SingletonEnum getInstance() {
        return INSTANCE;
    }

    public String getName() {
        return name;
    }

}
