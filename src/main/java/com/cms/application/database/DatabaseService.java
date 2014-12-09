package com.cms.application.database;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;


public class DatabaseService implements IDatabase {
    // Database constants -- these should be in a config
    private static final String username = "cms";
    private static final String url = "jdbc:h2:~/db"; // use file for persistance
    private static final String password = "";

    // SQL statements
    private static final String dropTable = "drop table entry_table if exists";
    private static final String createTable = "CREATE TABLE IF NOT EXISTS entry_table(key varchar, value varchar)";
    private static final String insertEntry = "INSERT INTO entry_table(key, value) values (?,?)";
    private static final String getEntry = "SELECT key, value from entry_table where key == ?";
    private static final String getAllEntries = "SELECT key, value from entry_table";
    private static final String removeEntries = "DELETE from entry_table where key == ?";

    // singleton variables
    private static DatabaseService _db = null;
    private static JdbcTemplate jdbcTemplate = null;

    // Get the instance, create if not made yet
    public static DatabaseService getInstance() {
        if(_db == null)
            _db = new DatabaseService();
        return _db;
    }

    // Singleton
    private DatabaseService() {
        setUpDBConnection();
        createTable();
    }

    // Create the table, query checks if it exists
    private void createTable() {
        jdbcTemplate.execute(createTable);
    }

    // Insert value into the database
    public int insert(String key, String value) {
        if(jdbcTemplate == null)
            setUpDBConnection();
        return jdbcTemplate.update(insertEntry, key, value);
    }

    // Remove all values from the database
    public void removeValues() {
        jdbcTemplate.execute(removeEntries);
    }


    // Return a sum of the values in the database
    public Map<String, String> select(String key) {
        // Get values from database
        Map<String, String> map = new HashMap();
        List<AbstractMap.SimpleEntry<String, String>> results = jdbcTemplate.query(
                getEntry, (RowMapper) (rs, rowNum) -> new HashMap.SimpleEntry<String, String>(rs.getString("key"), rs.getString("value")) {});
        for(Map.Entry<String, String> e : results) {
            map.put(e.getKey(), e.getValue());
        }
        return map;
    }

    public Map<String, String> selectAll() {
        // Get values from database
        Map<String, String> map = new HashMap();
        List<AbstractMap.SimpleEntry<String, String>> results = jdbcTemplate.query(
                getAllEntries, (RowMapper) (rs, rowNum) -> new HashMap.SimpleEntry<String, String>(rs.getString("key"), rs.getString("value")) {});
        for(Map.Entry<String, String> e : results) {
            map.put(e.getKey(), e.getValue());
        }
        return map;
    }

    // Set up the database
    private void setUpDBConnection() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.h2.Driver.class);
        dataSource.setUsername(username);
        dataSource.setUrl(url);
        dataSource.setPassword(password);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
}