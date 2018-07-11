package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {

    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    private static final ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common");

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        try {
            String s = bis.readLine();
            if (s.equalsIgnoreCase("EXIT")) {
                throw new InterruptOperationException();
            } return s;
        } catch (IOException e) {
            return "";
        }
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));

        String currency;
        while (true) {
            currency = readString();
            if (currency.length() == 3) {
                break;
            } else {
                writeMessage(res.getString("invalid.data"));
            }
        }

        return currency.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));

        String[] array;
        while (true) {
            array = readString().split(" ");

            if (array.length != 2) {
                writeMessage("invalid data");
                continue;
            }

            int firstNumber;
            int secondNumber;

            try {
                firstNumber = Integer.parseInt(array[0]);
                secondNumber = Integer.parseInt(array[1]);
            } catch (Exception e) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }

            if (firstNumber <= 0 || secondNumber <= 0) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            break;
        }

        return array;
    }

    public static Operation askOperation() throws InterruptOperationException {
        writeMessage("choose operation");

        int numberOfOperation;

        while (true) {
            try {
                numberOfOperation = Integer.parseInt(readString());
            } catch (NumberFormatException ignore) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }

            if (numberOfOperation < 1 || numberOfOperation > 4) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            break;
        }

        return Operation.getAllowableOperationByOrdinal(numberOfOperation);
    }

    public static void printExitMessage() {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }
}
