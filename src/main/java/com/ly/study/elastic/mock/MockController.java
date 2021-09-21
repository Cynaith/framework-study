package com.ly.study.elastic.mock;


import cn.hutool.json.JSONUtil;
import com.ly.study.elastic.dataOperator.EntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mock")
public class MockController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MockDao mockDao;

    @PostMapping("/add")
    public void insertMock() throws SQLException {
        String sql = "select * from zb_dream";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(JSONUtil.toJsonStr(list));


        List<ZgDream> zgDreamList = new ArrayList<>();

        mockDao.saveAll(zgDreamList);
    }

}
