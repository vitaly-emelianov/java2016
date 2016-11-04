package ru.sbt.classwork_3110;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by vitaly on 31.10.16.
 */
public class ReflectionUtils {
    public static List<Field> printMethodInfo (Object o) {
        List<Field> fields = new ArrayList<>();
        Class<?> clazz = o.getClass();
        while (clazz != null) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        return fields;
    }

    public static List<Object> printAllInvokedGetters(Object o) {
        List<Object> invocations = new ArrayList<>();
        Class<?> clazz  = o.getClass();
        while (clazz != null) {
            List<Method> getters = new ArrayList<>();
            for (Method method: clazz.getDeclaredMethods()) {
                if (method.getName().startsWith("get")) {
                    getters.add(method);
                    try {
                        method.setAccessible(true);
                        invocations.add(method.invoke(o));
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            clazz = clazz.getSuperclass();
        }
        return invocations;
    }


    public static void main(String[] args) {
        Integer a = 12;
        ReflectionUtils reflectionUtil = new ReflectionUtils();
        Person p = new Person("amanda", "russel", 122);
        System.out.println(reflectionUtil.printAllInvokedGetters(p));
    }
}

