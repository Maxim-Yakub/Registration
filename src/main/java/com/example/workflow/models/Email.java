package com.example.workflow.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "email")
public class Email {
    @Id
    String id;

    @Field(type = FieldType.Text, name = "domain")
    private String domain;

    public Email(String domain) {
        this.domain = domain;
    }

}
