package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        IncomeData incomeData = new IncomeData() {
            public String getCountryCode() { return "UA"; }

            public String getCompany() { return "JavaRush Ltd."; }

            public String getContactFirstName() { return "Ivan"; }

            public String getContactLastName() { return "Ivanov"; }

            public int getCountryPhoneCode() { return 38; }

            public int getPhoneNumber() { return 501234567; }
        };

        IncomeDataAdapter incomeDataAdapter = new IncomeDataAdapter(incomeData);

        System.out.println(incomeDataAdapter.getPhoneNumber());
    }

    public static class IncomeDataAdapter implements Contact, Customer {

        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("+").append(data.getCountryPhoneCode()).append("(0");
            String a = "" + data.getPhoneNumber();
            String s = "";
            if (a.length() < 10) {
                for (int i = 0, j = a.length(); i < 9 - j; i++) {
                    s += "0";
                }
                s += a;
            }
            stringBuilder.append(s.substring(0,2)).append(")");
            stringBuilder.append(s.substring(2,5)).append("-").append(s.substring(5,7));
            stringBuilder.append("-").append(s.substring(7,9));

            return stringBuilder.toString();
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}