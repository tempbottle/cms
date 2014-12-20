package com.cms.application.controllers;

import com.cms.application.models.EntryRepository;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import com.cms.application.models.Entry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.joda.time.DateTime;


import org.springframework.data.mongodb.MongoDbFactory;

import com.mongodb.DB;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rkonell on 12/6/14.
 */
@Configuration
@RestController
public class ContentController{

    @Autowired
    private EntryRepository repository;

    private MongoDbFactory mongo;

// get application context
// get the database connection from the context

    @RequestMapping(value="/post", method= RequestMethod.POST)
    public Entry post( @RequestParam(value="title", defaultValue="title") String title
                      , @RequestParam(value="body", defaultValue="body") String body
                      , @RequestParam(value="user", defaultValue="user1") String user
                      ) {
        try {
            mongo = new SimpleMongoDbFactory(new MongoClient("localhost", 3001), "yourdb");
        }
        catch (Exception e) {

        }
        MongoOperations ops = (MongoOperations) new MongoTemplate(mongo);

        Entry entry = new Entry( title
                                        , body
                                        , user
                                        , new ArrayList()
                                        , new ArrayList()
                                        , DateTime.now()
                               );
        ops.save(entry);
        return entry;
    }

    @RequestMapping(value="/list", method=RequestMethod.GET)
    public List<Entry> list() {
        List<Entry> list = new ArrayList<Entry>(); // res.keySet().stream().map(k -> new Entry(k, res.get(k))).collect(Collectors.toList());
        return list;
    }

}
