package com.zaxk.study.spring.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ZhuXu on 2016/10/10 0010.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/app*.xml")
@Transactional
public class TestSpringDAOTest {

    @Autowired
    TestSpringDAO testSpringDAO;

    @Test
    public void getMapper() throws Exception {

    }

    @Test
    public void list() throws Exception {

    }

    @Test
    public void insert() throws Exception {
        testSpringDAO.insert(12, "zaxk");
    }

}