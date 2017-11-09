package com.zaxk.study.spring.action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.zaxk.study.spring.dao.TestSpringDAO;
import com.zaxk.study.spring.service.UserService;
import com.zaxk.study.spring.struts.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ZhuXu on 2016/10/8 0008.
 */
public class IndexAction extends ActionSupport {

    private static final Logger LOG = LoggerFactory.getLogger(IndexAction.class);

    @Autowired
    private TestSpringDAO testSpringDAO;
    private UserService userService;
    private int id;
    private String name;
    private String str;

    @Override
    public String execute() throws Exception {
        List list = userService.list(2, 5);
        str = new Gson().toJson(list);
        return SUCCESS;
    }

    public JsonResult add() {
        LOG.info("add id:{}, name:{}", id, name);
        try {
            testSpringDAO.insert(id, name);
        } catch (Exception e) {
            System.out.println(JsonResult.fail("添加失败" + e.getCause()));
            return JsonResult.fail("添加失败" + e.getMessage());
        }

        List list = testSpringDAO.list();
        return new JsonResult().put("list", new Gson().toJson(list));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStr() {
        return str;
    }
}
