package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {

    @Deprecated
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("d:\\tmp.tmp", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            User user1 = new User();
            user1.setFirstName("Vasy");
            user1.setLastName("Petrov");
            user1.setBirthDate(new Date());
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);

            javaRush.users.add(user1);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            if (javaRush.equals(loadedObject)) {
                System.out.println("javaRush.equals(loadedObject) = true");
            } else {
                System.out.println("javaRush.equals(loadedObject) = false");
            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try (PrintWriter printWriter = new PrintWriter(outputStream)) {

                if (!users.isEmpty()) {
                    users.forEach((user) -> printWriter.println(user.getFirstName() + "\n"
                            + user.getLastName() + "\n"
                            + user.getBirthDate().getTime() + "\n"
                            + user.isMale() + "\n"
                            + user.getCountry().getDisplayedName()));
//                    for (User user : users) {
//                        printWriter.println(user.getFirstName());
//                        printWriter.println(user.getLastName());
//                        printWriter.println(user.getBirthDate().getTime());
//                        printWriter.println(user.isMale());
//                        printWriter.println(user.getCountry().getDisplayedName());
//                    }
                }

            }
        }

        @Deprecated
        public void load(InputStream inputStream) throws Exception {

            try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream))) {

                while (fileReader.ready()) {
                    User user = new User();
                    user.setFirstName(fileReader.readLine());
                    user.setLastName(fileReader.readLine());
                    user.setBirthDate(new Date(Long.parseLong(fileReader.readLine())));
                    user.setMale(Boolean.parseBoolean(fileReader.readLine()));
                    String country = fileReader.readLine();
                    user.setCountry(country.equals(User.Country.UKRAINE.getDisplayedName())
                            ? User.Country.UKRAINE
                            : (country.equals(User.Country.RUSSIA.getDisplayedName())
                                ? User.Country.RUSSIA
                                : User.Country.OTHER));

                    users.add(user);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
