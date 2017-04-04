package com.alexstudy.courses.onlinejavalessons.advanced.annotations_reflection;

/**
 * Created by apop on 4/4/2017.
 */
public class LazyService {
    @Init
    void initService() {
        System.out.println("init service");
    }
}
