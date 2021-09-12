package com.ly.study.elastic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/elastic-search")
public class EntityController {

    @Autowired
    private EntityDao entityDao;

    @RequestMapping("findAll")
    public Iterable<EntityBean> findAll() {
        return entityDao.findAll();
    }

    @RequestMapping("findByName")
    public List<EntityBean> findByName(String name) {
        return entityDao.findByName(name);
    }

}
