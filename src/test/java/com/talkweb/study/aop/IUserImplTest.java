package com.talkweb.study.aop;

import com.talkweb.study.dao.TestSpringDAO;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ZhuXu on 2016/10/10 0010.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/app*.xml")
@Transactional
public class IUserImplTest extends TestCase {

    private static final Logger LOG = LoggerFactory.getLogger(IUserImplTest.class);

    @Autowired
    IUser iUser;

    @Test
    @Rollback(false)
    public void testAddUser() throws Exception {
        iUser.addUser("zaxk");
    }

    @Test
    public void testFindAll() throws Exception {
        iUser.findAll();
    }

    @Test
    public void testFindUser() throws Exception {
        iUser.findUser("zaxk");
    }

}