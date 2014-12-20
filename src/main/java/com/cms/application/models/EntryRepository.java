package com.cms.application.models;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by rkonell on 12/13/14.
 */
public interface EntryRepository extends MongoRepository<Entry, String> {

    public Entry findByTitle(String title);
    public List<Entry> findByUser(String user);

}
