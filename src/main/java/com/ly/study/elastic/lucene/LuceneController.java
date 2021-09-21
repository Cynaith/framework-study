package com.ly.study.elastic.lucene;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("lucene")
public class LuceneController {

    @Autowired
    private LuceneService luceneService;

    @PostMapping("createIndex")
    public void createIndex() throws IOException {
        luceneService.createIndex();
    }

    @PostMapping("searchIndex")
    public void searchIndex() throws IOException {
        luceneService.searchIndex();
    }
}
