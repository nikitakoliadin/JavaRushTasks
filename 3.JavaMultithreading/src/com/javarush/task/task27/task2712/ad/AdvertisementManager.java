package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementManager {

    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds;

    private SetList<List<Advertisement>, Long, Integer> setListOfActualAd;

    private class SetList<K, V, M> {

        private final K actualList;
        private final V amount;
        private final M totalDuration;


        public SetList(K actualList, V amount, M totalDuration) {
            this.actualList = actualList;
            this.amount = amount;
            this.totalDuration = totalDuration;
        }

        public K getActualList() {
            return actualList;
        }

        public V getAmount() {
            return amount;
        }
        public M getTotalDuration() {
            return totalDuration;
        }
    }

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> advertisementList = storage.list();

        if (advertisementList.isEmpty()) {
            throw new NoVideoAvailableException();
        }

        List<Advertisement> list= new ArrayList<>();
        advertisementList.forEach((ad)-> {
            if (ad.getHits() > 0) {
                list.add(ad);
            }
        });

        recursionForBestAd(list, new ArrayList<>(),0,0);

        setListOfActualAd.getActualList().sort((ad1, ad2) -> (int) (ad2.getAmountPerOneDisplaying() - ad1.getAmountPerOneDisplaying()));

        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(setListOfActualAd.getActualList(), setListOfActualAd.getAmount(), setListOfActualAd.getTotalDuration()));

        for (Advertisement advertisement : setListOfActualAd.getActualList()) {
            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... " +
                    advertisement.getAmountPerOneDisplaying() + ", " +
                    (int) (((double)advertisement.getAmountPerOneDisplaying() / (double) advertisement.getDuration()) * 1000)
            );
            advertisement.revalidate();
        }
    }

    private void recursionForBestAd(List<Advertisement> initialList,List<Advertisement> newList,int timeCook, long totalAmount ) {

        for (int i = 0; i < initialList.size() ; i++) {
            Advertisement advertisement = initialList.get(i);

            if ((advertisement.getDuration() + timeCook) <= timeSeconds) {

                List<Advertisement> newListForRecursion = new ArrayList<>(newList);
                newListForRecursion.add(advertisement);

                List<Advertisement> initListForRecursion = new ArrayList<>(initialList);
                initListForRecursion.remove(advertisement);

                recursionForBestAd(initListForRecursion,newListForRecursion, timeCook+advertisement.getDuration(), totalAmount+advertisement.getAmountPerOneDisplaying());
            }
            else {
                if (setListOfActualAd != null) {
                    if ((totalAmount > setListOfActualAd.getAmount())
                            || (totalAmount == setListOfActualAd.getAmount() && timeCook > setListOfActualAd.getTotalDuration())
                            || (totalAmount == setListOfActualAd.getAmount() && timeCook == setListOfActualAd.getTotalDuration() && (newList.size() < setListOfActualAd.getActualList().size()))) {
                        setListOfActualAd = new SetList<>(newList, totalAmount, timeCook);
                    }
                } else {
                    setListOfActualAd = new SetList<>(newList, totalAmount, timeCook);
                }
            }
        }

        if (setListOfActualAd != null) {
            if ((totalAmount> setListOfActualAd.getAmount())
                    || (totalAmount== setListOfActualAd.getAmount()&& timeCook> setListOfActualAd.getTotalDuration())
                    || (totalAmount== setListOfActualAd.getAmount()&& timeCook== setListOfActualAd.getTotalDuration() && (newList.size()< setListOfActualAd.getActualList().size())) ) {
                setListOfActualAd = new SetList<>(newList,totalAmount,timeCook);
            }
        }
        else {
            setListOfActualAd = new SetList<>(newList, totalAmount, timeCook);
        }
    }
}
