package com.alexstudy.courses.onlinejavalessons.advanced.annotations_reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by apop on 4/4/2017.
 */
public class AnnotationMapper {
    static Map<String, Object> services = new HashMap<>();

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        loadService("com.alexstudy.courses.onlinejavalessons.advanced.annotations_reflection.SimpleService");
        loadService("com.alexstudy.courses.onlinejavalessons.advanced.annotations_reflection.LazyService");
        loadService("java.lang.String");
        System.out.println(services);
    }

    static void loadService(String className) throws IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        Class<?> clazz = Class.forName(className);
        Object instance = clazz.newInstance();

        if (clazz.isAnnotationPresent(Service.class)) {
            String serviceName = className.substring(className.lastIndexOf('.') + 1);
            services.put(serviceName, instance);
            System.out.println("added new service '" + serviceName + "'");
            if (!clazz.getAnnotation(Service.class).lazyLoad()) {
                System.out.println("searching for 'init' methods...");
                for (Method method : clazz.getMethods()) {
                    if (method.isAnnotationPresent(Init.class)) {
                        System.out.println("init annotation found, trying to invoke method...");
                        if (method.getAnnotation(Init.class).supressException()) {
                            try {
                                method.invoke(instance);
                            } catch (InvocationTargetException e) {
                                System.out.println("exception caught");
                            }
                        } else {
                            method.invoke(instance);
                        }
                        System.out.println("invoking success!");
                    }
                }
            }
        }
    }

}