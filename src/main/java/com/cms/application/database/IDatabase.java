package com.cms.application.database;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rkonell on 12/6/14.
 */
public interface IDatabase {
    int insert(String title, String post);
    Map<String, String> select(String key);
    Map<String, String> selectAll();
}
