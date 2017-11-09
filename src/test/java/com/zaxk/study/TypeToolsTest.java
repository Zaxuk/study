package com.zaxk.study;

import java.util.ArrayList;

/**
 * Created by ZhuXu on 2016/10/12 0012.
 */
public class TypeToolsTest
{
    public static void main(String[] args)
    {
        int i=0;
        TypeObject to=new TypeObject();
        //1.反射
        System.out.println("to的类型:"+to.getClass().getSimpleName());
        System.out.println(int.class.getSimpleName());
        System.out.println(Integer.class.getSimpleName());
        //但是对于一个不确定类型的基本数据类型变量我们没法用反射来获取其类型。
        System.out.println("----------------------");

        //2.instanceof
        if(to instanceof TypeObject){ System.out.println("to是TypeObject类型的");}
        //但是这种办法貌似也没法确定基本数据类型
        System.out.println("----------------------");

        //以上两种方式对于对象，引用类型的都很好用，但是对基本数据类型就不那么好用了。
        //3.通过多态(方法的重载)
        System.out.println("i是："+TypeTools.getType(i));
        System.out.println("to是："+TypeTools.getType(to));
        System.out.println("\"cxyapi\"是："+TypeTools.getType(new ArrayList<>()));
        //大家可以看出来 最后一种方式使用多态的方式达到了检测类型(基本类型和引用类型)的目的
        //它除了弥补其他两种方式不能检测基本数据类型的不足在外，还能自己DIY类型信息
    }
}

//定义一个类，为了演示引用类型的类型检测
class TypeObject{}
