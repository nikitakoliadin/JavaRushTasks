package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() throws IllegalAccessException, InstantiationException {
        Class<?>[] declaredClasses = Collections.class.getDeclaredClasses();

        for (Class<?> clazz : declaredClasses) {
            List<Class> listOfSuperClasses = new ArrayList<>();

            Class superClass = clazz.getSuperclass();
            while (superClass != null) {
                listOfSuperClasses.add(superClass);
                superClass = superClass.getSuperclass();
            }

            for (Class item : listOfSuperClasses) {
                Class<?>[] interfaces = item.getInterfaces();

                for (Class anInterface : interfaces) {
                    if (anInterface.getSimpleName().equals("List")) {
                        Method[] methods = clazz.getMethods();

                        for (Method method : methods) {
                            if (method.getName().equals("get")) {
                                try {
                                    Constructor declaredConstructor = clazz.getDeclaredConstructor();
                                    declaredConstructor.setAccessible(true);
                                    List list = (List) declaredConstructor.newInstance();
                                    list.get(0);
                                } catch (IndexOutOfBoundsException e) {
                                    return clazz;
                                } catch (Exception ignore) {
                                }
                            }
                        }
                    }
                }
            }
        }

        return null;
    }
}
