package com.ly.study.elastic.lucene;


import cn.hutool.core.io.file.FileReader;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class LuceneService {

    public void createIndex() throws IOException {
        Directory directory = FSDirectory.open(new File("C:\\Users\\Cynaith\\IdeaProjects\\framework-study\\static\\indexDoc").toPath());
        IndexWriterConfig config = new IndexWriterConfig();

        IndexWriter writer = new IndexWriter(directory, config);

        File dir = new File("C:\\Users\\Cynaith\\IdeaProjects\\framework-study\\static\\sourceDoc");
        File[] files = dir.listFiles();
        for (File file : files) {
            String fileName = file.getName();
            String filePath = file.getPath();
            String fileContent = new FileReader(file).readString();

            Field fieldName = new TextField("name", fileName, Field.Store.YES);
            Field fieldPath = new TextField("path", filePath, Field.Store.YES);
            Field fieldContent = new TextField("fileContent", fileContent, Field.Store.YES);

            Document document = new Document();
            document.add(fieldName);
            document.add(fieldPath);
            document.add(fieldContent);

            writer.addDocument(document);
        }
        writer.close();
    }

    public void searchIndex() throws IOException {
        Directory dir = FSDirectory.open(new File("C:\\Users\\Cynaith\\IdeaProjects\\framework-study\\static\\indexDoc").toPath());
        IndexReader indexReader = DirectoryReader.open(dir);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        Query query = new TermQuery(new Term("fileContent", "You"));
        TopDocs topDocs = indexSearcher.search(query, 10);

        System.out.println("总数:"+ topDocs.totalHits);

        ScoreDoc[] scoreDoc = topDocs.scoreDocs;
        for (ScoreDoc doc : scoreDoc) {
            int docId = doc.doc;

            Document document = indexSearcher.doc(docId);

            System.out.println(document.get("name"));
            System.out.println(document.get("path"));
            System.out.println(document.get("fileContent"));
        }

        indexReader.close();

    }
}
