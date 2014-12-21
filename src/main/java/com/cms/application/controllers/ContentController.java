package com.cms.application.controllers;

import com.cms.application.models.EntryRepository;
import com.cms.application.models.Entry;
import java.util.List;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rkonell on 12/6/14.
 */
@Configuration
@RestController
public class ContentController{

    @Autowired
    private EntryRepository repository;

    @RequestMapping(value="/post", method= RequestMethod.POST)
    public long post( @RequestParam(value="title", defaultValue="title") String title
                      , @RequestParam(value="body", defaultValue="body") String body
                      , @RequestParam(value="user", defaultValue="user1") String user
                      ) {
        Entry entry = new Entry(title, body, user, null, null, DateTime.now());
        repository.save(entry);
        return repository.count();
    }

    @RequestMapping(value="/list", method=RequestMethod.GET)
    public List<Entry> list() {
        return repository.findAll();
    }

}
