package com.ly.study.elastic.dataOperator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/elastic-search")
public class EntityController {

    @Autowired
    private EntityDao entityDao;

    @PostMapping("findAll")
    public Iterable<EntityBean> findAll() {
        return entityDao.findAll();
    }

    @PostMapping("findByName")
    public List<EntityBean> findByName(String name) {
        return entityDao.findByName(name);
    }

    @PostMapping("/init")
    public void init() {
        EntityBean bean = new EntityBean();
        bean.setId(1);
        bean.setMsg("1");
        bean.setName("1");
        entityDao.save(bean);
    }

}
