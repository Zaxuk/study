package com.zaxk.study.spring.cache;

import com.alibaba.fastjson.JSONObject;
import com.zaxk.study.spring.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

/**
 * Created by zWX435453 on 2017/8/24/0024.
 */
public class MyCacheKeyGenerator implements KeyGenerator {

    public static final Logger LOG = LoggerFactory.getLogger(MyCacheKeyGenerator.class);

    public static final int NO_PARAM_KEY = 0;

    @Override
    public Object generate(Object target, Method method, Object... params) {
        StringBuilder key = new StringBuilder();
        key.append(target.getClass().getName()).append(".").append(method.getName()).append(".");
        if (params.length == 0) {
            return key.append(NO_PARAM_KEY).toString();
        }

        StringBuilder sbParam = new StringBuilder();
        for (Object param : params) {
            sbParam.append(JSONObject.toJSONString(param));
        }

        LOG.debug("key:{}", sbParam.toString());

        key.append(MD5Util.string2MD5(sbParam.toString()));

        return key.toString();
    }
}
