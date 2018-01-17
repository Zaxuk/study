package com.zaxk.study;

/**
 * Created by ZhuXu on 2017/11/21 0021.
 */
public class TestExtend {
    public static void main(String[] args) {
        new Child();
    }
}

class Father {
    public Father() throws UnsupportedOperationException {
        System.out.println("I am father");
    }
}

class Child extends Father {
    public Child() throws UnsupportedOperationException {
        System.out.println("I am child");
    }
}
