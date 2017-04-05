package com.alexstudy.courses.onlinejavalessons.advanced.annotations_reflection;

/**
 * Created by apop on 4/4/2017.
 */
@Service(name = "test")
public class LazyService {
    @Init(supressException = true)
    public void initService() {
        System.out.println("init service method body");
        throw new RuntimeException();
    }
}
