package com.zaxk.study.pattern;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/**
 * 适配器模式
 * Created by ZhuXu on 2017/11/14 0014.
 */
public class AdapterTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Iterator iterator = list.iterator();
        Enumeration enumeration = new IteratorEnumeration(iterator);
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

    }
}

class IteratorEnumeration implements Enumeration {

    Iterator iterator;

    IteratorEnumeration(Iterator iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public Object nextElement() {
        return iterator.next();
    }
}
