package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class DirectorTablet {

    public void printAdvertisementProfit() {
        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<String, Long> data = statisticManager.getAdvertisementData();

        double totalAmount = 0.0;

        for (Map.Entry<String, Long> pair : data.entrySet()) {
            String date = pair.getKey();
            long amount = pair.getValue();
            if (amount > 0) {
                double amountInDollars = (double) amount / 100;
                ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", date, amountInDollars));
                totalAmount += amountInDollars;
            }
        }
        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", totalAmount));
    }

    public void printCookWorkloading() {
        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<String, Map<String, Integer>> data = statisticManager.getCookData();

        for (Map.Entry<String, Map<String, Integer>> firstPair : data.entrySet()) {
            String date = firstPair.getKey();
            ConsoleHelper.writeMessage(date);
            for (Map.Entry<String, Integer> secondPair : firstPair.getValue().entrySet()) {
                String cookName = secondPair.getKey();
                int workingTimeInSec = secondPair.getValue();
                if (workingTimeInSec > 0) {
                    ConsoleHelper.writeMessage(String.format("%s - %d min", cookName, (int) Math.ceil((double) workingTimeInSec / 60)));
                }
            }
        }
    }

    public void printActiveVideoSet() {
        List<Advertisement> activeVideoList = StatisticAdvertisementManager.getInstance().getActiveVideoList();

        activeVideoList.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));

        for (Advertisement advertisement : activeVideoList) {
            ConsoleHelper.writeMessage(String.format("%s - %d", advertisement.getName(), advertisement.getHits()));
        }
    }

    public void printArchivedVideoSet() {
        List<Advertisement> notActiveVideoList = StatisticAdvertisementManager.getInstance().getNotActiveVideoList();

        notActiveVideoList.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));

        for (Advertisement advertisement : notActiveVideoList) {
            ConsoleHelper.writeMessage(String.format("%s", advertisement.getName()));
        }
    }
}
