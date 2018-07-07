package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        File[] files = new File(packageName).listFiles();

        ClassLoader classLoader = new ClassLoaderFromPath();

        for(File f : files) {
            Class<?> loadClass = ((ClassLoaderFromPath) classLoader).load(f.toPath());
            if (loadClass != null) {
                hiddenClasses.add(loadClass);
            }
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        for (Class<?> hiddenClass : hiddenClasses) {
            if (hiddenClass.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
                try {
                    Constructor[] declaredConstructors = hiddenClass.getDeclaredConstructors();

                    for (Constructor declaredConstructor : declaredConstructors) {
                        if (declaredConstructor.getParameterTypes().length == 0) {
                            declaredConstructor.setAccessible(true);

                            return (HiddenClass) declaredConstructor.newInstance(null);
                        }
                    }
                } catch (IllegalAccessException | InstantiationException | InvocationTargetException ignore) {
                    return null;
                }
            }
        }

        return null;
    }

    public static class ClassLoaderFromPath extends ClassLoader {

        public Class<?> load(Path path) {

            try {
                if (path.getFileName().toString().lastIndexOf(".class") == -1) {
                    return null;
                }

                byte[] bytes = Files.readAllBytes(path);
                return defineClass(null, bytes, 0, bytes.length);
            } catch (IOException ignore) {
            }

            return null;
        }
    }
}

