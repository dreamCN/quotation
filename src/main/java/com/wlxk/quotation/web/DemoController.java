package com.wlxk.quotation.web;

import com.wlxk.quotation.common.BaseResult;
import com.wlxk.quotation.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 鼠行止
 * @date: 2019/9/14
 */
@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/ok")
    public BaseResult ok() {
        return BaseResult.ok(userDao.selectById(1));
    }

}
