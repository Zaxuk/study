package com.zaxk.study;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by ZhuXu on 2017/11/22 0022.
 */


public class TestProxy {

    PersonBean person;

    TestProxy(PersonBean person) {
        this.person = person;
    }

    public static void main(String[] args) {
        System.out.println("I am sb");
    }

    PersonBean getNonOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), new NonOwnerInvocationHandler(person));
    }

    public <T> T getProxy(T t, InvocationHandler handler) {
        return (T) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), handler);
    }


}
