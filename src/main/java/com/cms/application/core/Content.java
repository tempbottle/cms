package com.cms.application.core;

import com.cms.application.database.IDatabase;

import java.util.Map;

/**
 * Created by rkonell on 12/7/14.
 */
public class Content {

    // create a TestDatabase implements IDatabase
    // Test case: Things go wrong
    // The test ipmelmenetation, we'd mock it so when testDatabase.insert(Anything, Anything) is called,
    // it returns an error
    public static int insert(IDatabase db, String title, String entry) {
        // check number of entries enterted (0 or 1)
        // if 1, good, let controller know all went well
        // if 0, bad, determine why (if possible), let controller know shit happened and why so it
        // can respond with proper error message
        return db.insert(title, entry);
    }

    public static Map<String, String> select(IDatabase db, String title) {
        return db.select(title);
    }

    public static Map<String, String> selectAll(IDatabase db) {
        return db.selectAll();
    }
}
