package com.zaxk.study;

interface Subject {
    void request();
}

/**
 * Created by ZhuXu on 2017/11/21 0021.
 */
public class TestInterface {

    Subject subject = new Proxy();
}

class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("This is real subject");
    }
}

class Proxy implements Subject {

    @Override
    public void request() {
        System.out.println("This is proxy");
    }
}