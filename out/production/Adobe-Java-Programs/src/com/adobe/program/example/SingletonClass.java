package com.adobe.program.example;


import java.lang.reflect.InvocationTargetException;

class Singleton {
    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}

class ThreadSafeSingleton {
    private static ThreadSafeSingleton singleton;

    private ThreadSafeSingleton() {
    }

    public static ThreadSafeSingleton getInstance() {
        if (singleton == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (singleton == null) {
                    singleton = new ThreadSafeSingleton();
                }
            }
        }
        return singleton;
    }
}


public class SingletonClass {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        System.out.println(Singleton.getInstance().hashCode());
        System.out.println(Singleton.getInstance().hashCode());
//        Singleton singleton = (Singleton)Class.forName("com.adobe.program.example.Singleton").newInstance();
//        System.out.println(singleton.hashCode());
//        Constructor<Singleton> constructor = Singleton.class.getConstructor();
//        Singleton singleton1 = constructor.newInstance();
//        System.out.println(singleton1.hashCode());
    }
}
