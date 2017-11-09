package com.zaxk.study.spring.mapper;

import com.zaxk.study.spring.pojo.TestSpring;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by ZhuXu on 2016/10/9 0009.
 */
public interface TestSpringMapper {

    @Select("select * from test_spring")
    List<TestSpring> list();

    @Insert("insert into test_spring values(#{id}, #{name})")
    void insert(@Param("id") int id, @Param("name") String name);

}
