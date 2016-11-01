package com.melkov.utils;

/**
 * Created by andrew on 26.10.16.
 */
public class UUIDGenerator {

    public static synchronized long createRandomUUID(){
        long number = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
        return number;
    }
}
