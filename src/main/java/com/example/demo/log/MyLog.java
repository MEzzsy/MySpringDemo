package com.example.demo.log;

/**
 * Created by mezzsy on 2019-11-17
 * Describe:
 */
public class MyLog {
    public static final String GLOBAL_TAG = "MySpringDemo";

    public static void d(String content) {
        d(GLOBAL_TAG, content);
    }

    public static void d(String tag, String content) {
        System.out.println(tag + " : " + content);
    }
}
