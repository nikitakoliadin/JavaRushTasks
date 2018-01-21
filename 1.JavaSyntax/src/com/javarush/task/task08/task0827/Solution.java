package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Date dateDone = new Date(date);
        Date dateFromDoneYear = new Date();
        dateFromDoneYear.setMonth(0);
        dateFromDoneYear.setDate(1);
        dateFromDoneYear.setYear(dateDone.getYear());
        dateFromDoneYear.setSeconds(0);
        dateFromDoneYear.setMinutes(0);
        dateFromDoneYear.setHours(0);

        long countDay = dateDone.getTime() - dateFromDoneYear.getTime();
        int countDay2 = (int) (countDay / (60*60*24*1000));
        return !(countDay2%2==0);
    }
}
