package ru.sbt.homework_05;

import ru.sbt.classwork_3110.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by vitaly on 04.11.16.
 */
public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *    
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.   
     */
    public static Map<String, Method> getAllGetters(Object o) {
        Class<?> clazz = o.getClass();
        Map<String, Method> getters = new HashMap<>();
        while (clazz != null) {
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.getName().startsWith("get") && method.getParameterCount() == 0) {
                    getters.put(method.getName().substring(2), method);
                }
            }
            clazz = clazz.getSuperclass();
        }
        return getters;
    }

    public static Map<String, Method> getAllSetters(Object o) {
        Class<?> clazz = o.getClass();
        Map<String, Method> setters = new HashMap<>();
        while (clazz != null) {
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.getName().startsWith("set") && method.getReturnType().equals(Void.TYPE)
                        && method.getParameterCount() > 0) {
                    setters.put(method.getName().substring(2), method);
                }
            }
            clazz = clazz.getSuperclass();
        }
        return setters;
    }

    public static void assign(Object to, Object from) {
        Map<String, Method> getters = getAllGetters(from);
        Map<String, Method> setters = getAllSetters(to);

        for (Map.Entry<String, Method> entry : setters.entrySet()) {
            String name = entry.getKey();
            Method setter = entry.getValue();
            if (getters.containsKey(name) &&
                    setter.getParameterTypes()[0].getClass()
                            .isAssignableFrom(getters.get(name).getReturnType().getClass())) {
                try {
                    setter.invoke(to, getters.get(name).invoke(from));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Person alex = new Person("alex", "scott", 30);
        Person jack = new Person("amanda", "russel", 25);
        System.out.println(alex);
        System.out.println(jack);
        assign(jack, alex);
        System.out.println(alex);
        System.out.println(jack);
    }
}