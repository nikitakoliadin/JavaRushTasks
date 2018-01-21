package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        String URL = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            URL = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> listParametr = new ArrayList<>();

        int index = URL.indexOf("?");
        String params = URL.substring(index+1, URL.length());
        String[] arrParams = params.split("&");

        for (String s:arrParams){                           //перебираем массив параметров
            index = s.indexOf("=");                         //ищем знак равенства в параметре
            if(index > 0) {                                 //если параметр содержит знак =
                String tmpString = s.substring(0, index);   //забираем имя до знака
                System.out.print(tmpString + " ");          //печатаем в консоль
                if (tmpString.contains("obj")) {            //если имя содержит obj
                    listParametr.add(s.substring(index + 1));//заносим его параметр в аррайлист
                }
            }
            else {
                System.out.print(s + " ");//если нет знака равенства печатаем в консоль целиком
            }
        }

        System.out.println();

        for (String v: listParametr){
//            if(v.contains(".")){//если параметр содержит точку
                try {
                    alert(Double.parseDouble(v));//пробуем его конвертировать в дабл и, если успешно - печатаем в консоль
                }catch (NumberFormatException e){
                    alert(v);//при невозможности конвертации печатаем как стринг
                }
//            }
        }


    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
