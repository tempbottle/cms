package com.cms.application.configs;

/**
 * Created by rkonell on 12/7/14.
 */
public interface IConfig {
    String get(String key);
    String put(String key, String value);
}
