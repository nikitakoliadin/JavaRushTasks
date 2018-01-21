package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> keys = new ArrayList<String>();
        keys.add("cartoon");
        keys.add("thriller");
        keys.add("soapOpera");

        List<String> list = new ArrayList<String>();

        String s;
        do {
            s = reader.readLine();
            list.add(s);

            if (!(s.equals("cartoon") || s.equals("thriller") || s.equals("soapOpera"))) {
                break;
            }
        } while(true);

        List<Movie> movies = new ArrayList<>();

        for (String ss : list) {
            movies.add(MovieFactory.getMovie(ss));
        }

        for (Movie movie : movies) {
            if (movie != null) {
                System.out.println(movie.getClass().getSimpleName());
            }
        }

        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            } else if (key.equals("cartoon")) {
                movie = new Cartoon();
            } else if (key.equals("thriller")) {
                movie = new Thriller();
            }

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie {

    }

    static class Thriller extends Movie {

    }
}
