package com.zaxk.study.spring.service;


import com.zaxk.study.mybatis.Page;
import com.zaxk.study.spring.dao.UserMapper;
import com.zaxk.study.spring.pojo.User;
import com.zaxk.study.spring.pojo.UserExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhuXu on 2016/11/18 0018.
 */
@Service
public class UserService {

    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    public static final String SPLIT_CHAR = ":";

    @Autowired
    UserMapper userMapper;

    public List<User> list(Page page) {
        UserExample userExample = new UserExample();
        userExample.setPage(page);
        return userMapper.selectByExample(userExample);
    }

    public List<User> list(int begin, int end) {
        Page page = new Page(begin, end);
        return list(page);
    }


}
