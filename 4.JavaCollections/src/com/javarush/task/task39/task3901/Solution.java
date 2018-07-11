package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        List<Integer> lengthList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            String subString = s.substring(i, s.length());

            StringBuilder stringNoRepeat = new StringBuilder();
            stringNoRepeat.append(s.charAt(0));

            exit:
            for (int j = 0; j < subString.length(); j++) {
                for (int k = 0; k < stringNoRepeat.length(); k++) {
                    if (stringNoRepeat.charAt(k) == subString.charAt(j)) {
                        break exit;
                    }
                }
                stringNoRepeat.append(subString.charAt(j));
            }
            lengthList.add(stringNoRepeat.toString().length());
        }

        return Collections.max(lengthList);
    }
}
