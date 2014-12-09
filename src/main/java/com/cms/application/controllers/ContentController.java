package com.cms.application.controllers;

import com.cms.application.core.Content;
import com.cms.application.database.DatabaseService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContext;
import com.cms.application.models.Entry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by rkonell on 12/6/14.
 */

@RestController
public class ContentController {

// get application context
// get the database connection from the context

    @RequestMapping(value="/post", method= RequestMethod.POST)
    public String post(@RequestParam(value="title", defaultValue="title") String title, @RequestParam(value="entry", defaultValue="entry") String entry) {
        return String.valueOf(Content.insert(DatabaseService.getInstance(), title, entry));
    }

    @RequestMapping(value="/list", method=RequestMethod.GET)
    public List<Entry> list() {
        Map<String, String> res = Content.selectAll(DatabaseService.getInstance());
        List<Entry> list = res.keySet().stream().map(k -> new Entry(k, res.get(k))).collect(Collectors.toList());
        return list;
    }

}
