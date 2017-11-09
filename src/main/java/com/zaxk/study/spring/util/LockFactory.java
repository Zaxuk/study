package com.zaxk.study.spring.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 获取锁
 *
 * @author peng.zhang
 */
public class LockFactory {

    public static final Map<Object, Object> lockMap = new HashMap<Object, Object>();

    public static synchronized Object getLock(String cacheKey) {
        Object lock;
        int hash = cacheKey.hashCode();
        System.out.println(hash);
        if (!LockFactory.lockMap.containsKey(hash)) {
            lock = new Object();
            LockFactory.lockMap.put(hash, lock);
        } else {
            lock = LockFactory.lockMap.get(hash);
        }

        return lock;
    }
}
