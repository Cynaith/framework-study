package com.ly.study.elastic.mock;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@Document(indexName = "es_dream")
public class ZgDream {

    public static String ID = "id";
    public static String TITLE = "title";
    public static String MESSAGE = "message";
    public static String BIGLX = "biglx";
    public static String SMALLLX = "smalllx";

    @Id
    private long id;
    @Field(analyzer = "ik_smart", type = FieldType.Text)
    private String title;
    @Field(analyzer = "ik_smart", type = FieldType.Text)
    private String message;
    @Field(analyzer = "ik_smart", type = FieldType.Text)
    private String biglx;
    @Field(analyzer = "ik_smart", type = FieldType.Text)
    private String smalllx;
}
