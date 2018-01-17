package com.zaxk.study.pattern;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式
 * Created by ZhuXu on 2017/11/9 0009.
 */
public class ObserverTest {

    public static void main(String[] args) {
        School school = new School();
        Student student = new Student(school);
        Teacher teacher = new Teacher(school);
        school.notice();
    }
}

/**
 * 观察者：学生
 */
class Student implements Observer {

    Observable observable;

    public Student(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof School) {
            System.out.println("Student 收到通知:" + ((School) o).getNotice());
        }
    }
}

/**
 * 观察者：老师
 */
class Teacher implements Observer {

    Observable observable;

    public Teacher(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof School) {
            System.out.println("Teacher 收到通知:" + ((School) o).getNotice());
        }
    }
}

/**
 * 被观察者：学校
 */
class School extends Observable {

    String notice;

    public void notice() {
        setNotice("放假通知：1~7号放假");
        setChanged();
        notifyObservers();
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
