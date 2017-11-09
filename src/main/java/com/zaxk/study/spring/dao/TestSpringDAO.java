package com.zaxk.study.spring.dao;

import com.zaxk.study.spring.mapper.TestSpringMapper;
import com.zaxk.study.spring.pojo.TestSpring;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ZhuXu on 2016/10/9 0009.
 */
@Service
public class TestSpringDAO {

    @Autowired
    SqlSession sqlSession;

    public TestSpringMapper getMapper() {
        return sqlSession.getMapper(TestSpringMapper.class);
    }

    public List<TestSpring> list() {
        return getMapper().list();
    }

    @Transactional
    public void insert(int id, String name) {
        getMapper().insert(id, name);
        if(id > 100) {
            throw new RuntimeException("ID不能大于100");
        }
    }

}
