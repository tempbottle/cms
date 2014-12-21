package com.cms.application.models;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rkonell on 12/6/14.
 */
@Document(collection = "entry")
public class Entry {


    @Id
    private String id;

    private final String title;
    private final String body;
    private final String user;
    private final List<String> tags;
    private final List<Pair<String, String>> attachmentIds;
    private final DateTime date;

    public Entry(String title
               , String body
               , String user
               , List<String> tags
               , List<Pair<String, String>> attachmentIds // list of (fileId -> dbName)
               , DateTime date) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.tags = tags != null ? tags : new ArrayList<String>();
        this.attachmentIds = attachmentIds != null ? attachmentIds : new ArrayList<Pair<String, String>>();
        this.date = date;
    }

    public String getId() { return this.id; }

    public String getTitle() { return this.title; }

    public String getBody() { return this.body; }

    public String getUser() { return this.user; }

    public String getTags() {
        String tags_ = "";
        for(String s: this.tags) tags_ += s + ",";
        return tags_;
    }

    public List<Pair<String, String>> getAttachmentIds() {
        return attachmentIds;
    }

    public DateTime getDate() { return this.date; }

    @Override
    public String toString() {
        return String.format(
                "post[title='%s', body='%s', user='%s', tags='%s', attachment ids='%s', date='%s']",
                title, body, user, getTags(), attachmentIds, date);
    }

}
