package com.zaxk.study.pattern;

/**
 * 单例模式
 * 线程不安全
 * Created by ZhuXu on 2017/11/10 0010.
 */
public class SingletonTest {

    private static SingletonTest instance;

    private SingletonTest() {
    }

    public static SingletonTest getInstance() {
        if (instance == null) {
            instance = new SingletonTest();
        }
        return instance;
    }
}

/**
 * 饿汉模式
 * 线程安全、每次调用都同步getInstance方法，影响效率
 */
class SingletonTest1 {

    private static SingletonTest1 instance;

    private SingletonTest1() {
    }

    public static synchronized SingletonTest1 getInstance() {
        if (instance == null) {
            instance = new SingletonTest1();
        }
        return instance;
    }
}

/**
 * 懒汉模式
 * 线程安全、JVM加载类时马上创建实例
 */
class SingletonTest2 {

    private static SingletonTest2 instance = new SingletonTest2();

    private SingletonTest2() {
    }

    public static SingletonTest2 getInstance() {
        return instance;
    }
}

/**
 * 双重检查加锁模式
 * 线程安全
 */
class SingletonTest3 {

    private volatile static SingletonTest3 instance;

    private SingletonTest3() {
    }

    public static SingletonTest3 getInstance() {
        if (instance == null) {
            synchronized (SingletonTest3.class) {
                if (instance == null) {
                    instance = new SingletonTest3();
                }
            }
        }
        return instance;
    }
}

