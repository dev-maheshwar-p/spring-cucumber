package com.test;

import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoBean {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongoBean(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }



    public void example() {


    }

}
