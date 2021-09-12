package com.ly.study.elastic;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "esTest")
public class EntityBean implements Serializable {

    @Id
    private long id;
    @Field(analyzer = "ik_smart", type = FieldType.Text)
    private String name;
    @Field(analyzer = "ik_smart", type = FieldType.Text)
    private String msg;

}
