package com.talkweb.study.dao;

import com.talkweb.study.mappers.BassQueryMainMapper;
import com.talkweb.study.pojos.BassQueryMain;
import com.talkweb.study.pojos.BassQueryMainExample;
import com.zaxk.study.mybatis.Page;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhuXu on 2016/10/9 0009.
 */
@Service
public class BassQueryMainDAO {

    @Autowired
    SqlSession sqlSession;

    public BassQueryMainMapper getMapper() {
        return sqlSession.getMapper(BassQueryMainMapper.class);
    }

    public List<BassQueryMain> list() {
        return getMapper().selectByExample(new BassQueryMainExample());
    }

    public List<BassQueryMain> list(int pageNo, int pageSize) {
        Page page = new Page(pageNo, pageSize);
        BassQueryMainExample bassQueryMainExample = new BassQueryMainExample();
        bassQueryMainExample.setPage(page);
        return getMapper().selectByExample(bassQueryMainExample);
    }

}
