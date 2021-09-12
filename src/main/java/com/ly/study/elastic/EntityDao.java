package com.ly.study.elastic;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EntityDao extends CrudRepository<EntityBean, Long> {

    public List<EntityBean> findByName(String name);
}
