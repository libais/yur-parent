package com.yur.springboot;

import org.springframework.boot.SpringApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<Class> list = new ArrayList<>();
        list.add(NoteApplication.class);
        list.add(RedisApplication.class);

        Class[] clazz = (Class[]) list.toArray(new Class[0]);
        SpringApplication.run(clazz , args);
    }
}