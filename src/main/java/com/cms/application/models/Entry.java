package com.cms.application.models;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rkonell on 12/6/14.
 */

public class Entry {

    private final String title;
    private final String body;
    //private final String user;
    //private final List<String> tags;


    public Entry(String title, String body) { //, String user, List<String> tags) {
        this.title = title;
        this.body = body;
        //this.user = user;
        //this.tags = tags;
    }

    public String getTitle() { return this.title; }

    public String getBody() { return this.body; }

    // public String getUser() { return this.user; }

//    public String getTags() {
//        String tags_ = "";
//        for(String s: this.tags) tags_ += s + ",";
//        return tags_;
//    }

    @Override
    public String toString() {
        return String.format(
                "post[title='%s', body='%s']", //, user='%s', tags='%s']",
                title, body); // , user, getTags());
    }

}
