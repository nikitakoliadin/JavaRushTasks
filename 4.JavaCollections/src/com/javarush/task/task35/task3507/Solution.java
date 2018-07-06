package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");

        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Set<Animal> set = new HashSet<>();

        File[] files = new File(pathToAnimals).listFiles();

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".class")) {
                String packageName = Solution.class.getPackage().getName() + ".data";

                Class<?> clazz = new MyClassLoader().load(file.toPath(), packageName);

                if (hasImplementsCurrentInterface(clazz)) {
                    if (hasNoArgsConstructor(clazz)) {
                        Animal animal = (Animal) clazz.newInstance();
                        set.add(animal);
                    }
                }
            }
        }

        return set;
    }

    private static boolean hasImplementsCurrentInterface(Class<?> clazz) {
        Class<?>[] interfaces = clazz.getInterfaces();

        for(Class currentInterface : interfaces) {
//            if (currentInterface.isInstance(Animal.class)) {
//                return true;
//            }
            if (currentInterface.getSimpleName().toString().equals("Animal")) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasNoArgsConstructor(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getConstructors();

        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterCount() == 0) {
                return true;
            }
        }

        return false;
    }

    private static class MyClassLoader extends ClassLoader {

        public Class<?> load(Path path, String packageName) {
            try {
                String className = packageName + "." + path.getFileName().toString().replace(".class", "");

                byte[] b = Files.readAllBytes(path);

                return defineClass(className, b, 0, b.length);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
