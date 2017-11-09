package com.zaxk.study.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by ZhuXu on 2016/10/8 0008.
 */
@Aspect
public class CheckUser {

    @Pointcut("execution(* com.zaxk.study.spring.aop.*.find*(..))")
    public void findUser(){
        System.out.println("**************The System is Searching Information For You****************");
    }

    @Pointcut("execution(* com.zaxk.study.spring.aop.*.add*(..))")
    public void checkAdd(){
        System.out.println("**************<< Add User >> Checking.....***************");
    }

    @Before("findUser()")
    public void beforeFind(){
        System.out.println(">>>>>>>> 准备搜查用户..........");
    }

    @After("findUser()")
    public void afterFind(){
        System.out.println(">>>>>>>>　搜查用户完毕..........");
    }

    @Before("checkAdd()")
    public void beforeAdd(){
        System.out.println(">>>>>>>>　增加用户--检查ing..........");
    }

    @After("checkAdd()")
    public void afterAdd(){
        System.out.println(">>>>>>>>　增加用户--检查完毕！未发现异常!..........");
    }

    //声明环绕通知
    @Around("findUser()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("进入方法---环绕通知");
        Object o = pjp.proceed();
        System.out.println("退出方法---环绕通知");
        return o;
    }
}
