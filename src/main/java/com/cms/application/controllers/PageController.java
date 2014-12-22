package com.cms.application.controllers;


/**
 * Created by rkonell on 12/20/14.
 */

import com.cms.application.models.Entry;
import com.cms.application.models.EntryRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private EntryRepository repository;

    // The index page is not pretty at the moment.  The display of the entries will call
    // upon the toString method defined in Entry.
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String root(Model model) {
        List<Entry> list = repository.findAll();
        model.addAttribute("entries", list);
        return "index";
    }

    @RequestMapping(value="/new_entry", method= RequestMethod.POST)
    public String post( @RequestParam(value="title", defaultValue="title") String title
            , @RequestParam(value="body", defaultValue="body") String body
            , @RequestParam(value="user", defaultValue="user1") String user
            , Model model
    ) {
        Entry entry = new Entry(title, body, user, null, null, DateTime.now());
        repository.save(entry);
        return root(model);
    }

}