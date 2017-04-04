package com.alexstudy.courses.onlinejavalessons.advanced.annotations_reflection;

/**
 * Created by apop on 4/4/2017.
 */
@Service(name = "test service")
public class SimpleService {

    @Init
    void lazyinit() throws Exception {
        System.out.println("lazy init");
    }

    void doStuff() {
        System.out.println("do stuff");
    }
}
