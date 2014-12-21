package com.cms.application.models;

/**
 * Created by rkonell on 12/20/14.
 */
public class Pair<K, V> {

    public final K x;
    public final V y;

    Pair(K x, V y) {
        this.x = x;
        this.y = y;
    }
}
