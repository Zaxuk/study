import com.zaxk.study.spring.aop.IUser;
import com.zaxk.study.spring.util.LockFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ZhuXu on 2016/10/8 0008.
 */
public class Test {

    public static void main(String as[]) throws InterruptedException {

            List list = new ArrayList();
            list.add("qqyumidi");
            list.add("corn");
            list.add(100);

            for (int i = 0; i < list.size(); i++) {
                String name = (String) list.get(i); // 1
                System.out.println("name:" + name);
            }
    }

    public static void testLock() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        lock("13129386222", 456);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.submit(runnable);
        }
    }

    public static void lock(String mobile, int batchId) throws InterruptedException {
        String lock = "luckDraw_" + mobile + "_" + batchId;
        synchronized (LockFactory.getLock(lock)) {
            System.out.println(">>>>>>>>>>>start");
            Thread.sleep(2 * 60 * 1000);
            System.out.println(">>>>>>>>>>>end");
        }
    }

    public static void testAop() {
        BeanFactory factory = new ClassPathXmlApplicationContext("spring/application-context.xml");
        IUser user = (IUser) factory.getBean("user");
        user.findAll();
        user.addUser("Zack");
        user.findUser("Zack");
    }

}

