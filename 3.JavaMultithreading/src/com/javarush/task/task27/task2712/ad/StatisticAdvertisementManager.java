package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {

    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();

    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    private StatisticAdvertisementManager() {
    }

    public List<Advertisement> getActiveVideoList() {
        List<Advertisement> advertisementList = new ArrayList<>();

        for(Advertisement advertisement : advertisementStorage.list()) {
            if (advertisement.getHits() > 0) {
                advertisementList.add(advertisement);
            }
        }

        return advertisementList;
    }

    public List<Advertisement> getNotActiveVideoList() {
        List<Advertisement> advertisementList = new ArrayList<>();

        for(Advertisement advertisement : advertisementStorage.list()) {
            if (advertisement.getHits() == 0) {
                advertisementList.add(advertisement);
            }
        }

        return advertisementList;
    }
}
