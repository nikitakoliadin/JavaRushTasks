package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    
    private static AdvertisementStorage ourInstance = new AdvertisementStorage();

    private final List<Advertisement> videos = new ArrayList<>();

    public static AdvertisementStorage getInstance() {
        return ourInstance;
    }

    private AdvertisementStorage() {
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60));
        add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60));
        add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));
/*
        add(new Advertisement(someContent, "1", 100, 10, 3 * 60));
        add(new Advertisement(someContent, "2", 100, 10, 15 * 60));
        add(new Advertisement(someContent, "3", 400, 2, 10 * 60));
        add(new Advertisement(someContent, "4", 400, 2, 20 * 60));
        add(new Advertisement(someContent, "5", 400, 2, 40 * 60));
        add(new Advertisement(someContent, "6", 400, 2, 30 * 60));
        add(new Advertisement(someContent, "7", 50, 10, 1 * 60));
        add(new Advertisement(someContent, "8", 50, 10, 2 * 60));
        add(new Advertisement(someContent, "9", 7000, -1, 10 * 60));


        Object content = new Object();
        add(new Advertisement(content, "JJJ1", 101, 2, 25 * 60));
        add(new Advertisement(content, "JJJ2", 205, 2, 6 * 60));
        add(new Advertisement(content, "JJJ3", 50222, 10, 10 * 60));
        add(new Advertisement(content, "JJJ4", 2077, 2, 4 * 60));
        add(new Advertisement(content, "JJJ6", 205, 1, 10 * 60 - 1));
        add(new Advertisement(content, "JJJ7", 75, -1, 300 * 60));
        add(new Advertisement(content, "JJJ8", 12, 1, 3 * 60));
*/
    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }
}
