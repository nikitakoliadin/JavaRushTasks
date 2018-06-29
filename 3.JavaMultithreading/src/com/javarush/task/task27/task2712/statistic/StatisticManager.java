package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {

    private static StatisticManager ourInstance = new StatisticManager();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticStorage statisticStorage = new StatisticStorage();

    private class StatisticStorage {

        private Map<EventType, List<EventDataRow>> storage = createMap();

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }

        private void put(EventDataRow data) {
            EventType eventType = data.getType();

            if (storage.containsKey(eventType)) {
                storage.get(eventType).add(data);
            } else {
                storage.put(eventType, new ArrayList<>());
            }
        }

        private Map<EventType, List<EventDataRow>> createMap() {
            Map<EventType, List<EventDataRow>> storage = new HashMap<>();

            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<>());
            }

            return storage;
        }
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public Map<String, Long> getAdvertisementData() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        Map<String, Long> result = new TreeMap<>((o1, o2) -> {
            try {
                return simpleDateFormat.parse(o1).compareTo(simpleDateFormat.parse(o2));
            } catch (ParseException e) {
                return 0;
            }
        });

        List<EventDataRow> eventDataRows = statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS);

        eventDataRows.forEach((eventDataRow) -> {
            VideoSelectedEventDataRow videoSelectedEventDataRow = (VideoSelectedEventDataRow) eventDataRow;

            String date = simpleDateFormat.format(videoSelectedEventDataRow.getDate());
            long amount = videoSelectedEventDataRow.getAmount();

            if (result.containsKey(date)) {
                result.put(date, amount + result.get(date));
            } else {
                result.put(date, amount);
            }
        });

        return result;
    }

    public Map<String, Map<String, Integer>> getCookData() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        Map<String, Map<String, Integer>> result = new TreeMap<>((o1, o2) -> {
            try {
                return simpleDateFormat.parse(o1).compareTo(simpleDateFormat.parse(o2));
            } catch (ParseException e) {
                return 0;
            }
        });

        List<EventDataRow> eventDataRows = statisticStorage.getStorage().get(EventType.COOKED_ORDER);

        eventDataRows.forEach((eventDataRow) -> {
            CookedOrderEventDataRow cookedOrderEventDataRow = (CookedOrderEventDataRow) eventDataRow;

            String cookName = cookedOrderEventDataRow.getCookName();
            String date = simpleDateFormat.format(cookedOrderEventDataRow.getDate());
            int time = cookedOrderEventDataRow.getTime();

            if (result.containsKey(date)) {
                Map<String, Integer> cookData = result.get(date);
                if (cookData.containsKey(cookName)) {
                    cookData.put(cookName, cookData.get(cookName) + time);
                } else {
                    cookData.put(cookName, time);
                }
                result.put(date, cookData);
            } else {
                Map<String, Integer> cookData = new TreeMap<>();
                cookData.put(cookName, time);
                result.put(date, cookData);
            }
        });

        return result;
    }
}
