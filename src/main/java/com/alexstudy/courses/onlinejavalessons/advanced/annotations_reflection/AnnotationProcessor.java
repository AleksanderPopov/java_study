package com.alexstudy.courses.onlinejavalessons.advanced.annotations_reflection;

import java.lang.reflect.Method;

/**
 * Created by apop on 4/4/2017.
 */
public class AnnotationProcessor {
    public static void main(String[] args) {
        inspectService(SimpleService.class);
        inspectService(LazyService.class);
        inspectService(String.class);
    }

    static void inspectService(Class<?> service) {
        System.out.println("=========================");
        System.out.println(service.getSimpleName());
        System.out.println("Finding Service annotation...");
        if (service.isAnnotationPresent(Service.class)) {
            System.out.println("Service annotation found" + service.getAnnotation(Service.class));
        }
        System.out.println("Finding init annotation...");
        for (Method method : service.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Init.class)) {
                System.out.println("Init annotation found" + method.getAnnotation(Init.class));
            }
        }
        System.out.println("=========================");
    }
}
