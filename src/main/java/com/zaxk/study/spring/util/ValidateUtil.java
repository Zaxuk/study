package com.zaxk.study.spring.util;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zWX435453 on 2017/4/5/0005.
 */
public final class ValidateUtil {

    private ValidateUtil() {
    }

    public static boolean isEmptyString(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isNotEmptyString(String str) {
        return !isEmptyString(str);
    }

    public static boolean isEmptyCollection(Collection collection) {
        return null == collection || collection.isEmpty();
    }

    public static boolean isNotEmptyCollection(Collection collection) {
        return !isEmptyCollection(collection);
    }

    public static boolean isEmptyMap(Map map) {
        return null == map || map.isEmpty();
    }

    public static boolean isNotEmptyMap(Map map) {
        return !isEmptyMap(map);
    }

    public static boolean equals(String left, String right) {
        if (null != left)
            return left.equals(right);
        else
            return null == right;
    }

    public static boolean isNumeric(String str) {
        if (isEmptyString(str))
            return false;
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

    public static boolean isNotEmptyAndLGZero(BigDecimal number) {
        return number != null && number.compareTo(BigDecimal.ZERO) > 0;
    }

}