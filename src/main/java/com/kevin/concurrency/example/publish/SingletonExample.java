package com.kevin.concurrency.example.publish;

/**
 * Created by Kevin on 2018/8/24.
 */
public class SingletonExample {
    private SingletonExample() {

    }

    public static SingletonExample getInstance() {
        return Singleton.INSTANCE.getSingleton();
    }

    private enum Singleton {
        INSTANCE;
        private SingletonExample singleton;

        Singleton() {
            singleton = new SingletonExample();
        }

        public SingletonExample getSingleton() {
            return singleton;
        }

    }

}
