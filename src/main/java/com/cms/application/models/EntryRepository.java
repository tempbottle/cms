package com.cms.application.models;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by rkonell on 12/13/14.
 */
public interface EntryRepository extends MongoRepository<Entry, String> {

    Entry findOne(String primaryKey);
    List<Entry> findAll();
    long count();
    void delete(Entry entry);
    List<Entry> findByTitle(String title);
    List<Entry> findByUser(String user);
    List<Entry> findByTags(List<String> tags);
    boolean exists (String primaryKey);

}
