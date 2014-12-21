package com.cms.application;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by rkonell on 12/20/14.
 */

@Configuration
@EnableMongoRepositories
public class ApplicationConfig extends AbstractMongoConfiguration {

    private static MongoDbFactory factory;

    private static String database = "cms";

    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Override
    public @Bean Mongo mongo() throws Exception {
        if(factory == null)
          factory = new SimpleMongoDbFactory(new MongoClient("127.0.0.1", 27017), database);
        return factory.getDb().getMongo();
    }
}