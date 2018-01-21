package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandPaName = reader.readLine();
        Cat grandPa = new Cat(grandPaName);

        String grandMaName = reader.readLine();
        Cat grandMa = new Cat(grandMaName);

        String paName = reader.readLine();
        Cat pa = new Cat(paName,null, grandPa);

        String maName = reader.readLine();
        Cat ma = new Cat(maName, grandMa, null);

        String boyName = reader.readLine();
        Cat boy = new Cat(boyName, ma, pa);

        String girlName = reader.readLine();
        Cat girl = new Cat(girlName, ma, pa);


        System.out.println(grandPa);
        System.out.println(grandMa);
        System.out.println(pa);
        System.out.println(ma);
        System.out.println(boy);
        System.out.println(girl);
    }

    public static class Cat {
        private String name;
        private Cat parentPapa;
        private Cat parentMama;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parentMama, Cat parentPapa) {
            this.name = name;
            this.parentPapa = parentPapa;
            this.parentMama = parentMama;
        }

        @Override
        public String toString() {
            if(parentMama == null && parentPapa == null) {
                return "Cat name is " + name + ", no mother, no father";
            } else if(parentPapa == null) {
                return "Cat name is " + name + ", mother is " + parentMama.name + ", no father";
            } else if(parentMama == null) {
                return "Cat name is " + name + ", no mother, father is " + parentPapa.name;
            } else {
                return "Cat name is " + name + ", mother is " + parentMama.name + ", father is " + parentPapa.name;
            }
        }
    }

}
