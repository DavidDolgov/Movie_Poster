package ru.netology.javaqa;

public class FilmManager {
    private int maximumLimit = 10;
    private FilmItem[] items = new FilmItem[0];

    public FilmManager() {
    }

    public FilmManager(int maximumLimit) {
        this.maximumLimit = maximumLimit;
    }

    public void save(FilmItem item) {
        FilmItem[] tmp = new FilmItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public FilmItem[] getItems() {
        return items;
    }

    public FilmItem[] findAll() {
        FilmItem[] all = getItems();
        return all;
    }

    public FilmItem[] findLast() {
        FilmItem[] all = getItems();
        int resultLength = all.length;
        if (resultLength > maximumLimit) {
            resultLength = maximumLimit;
        }
        FilmItem[] reversed = new FilmItem[resultLength];
        for (int i = 0; i < resultLength; i++) {
            reversed[i] = all[all.length - 1 - i];
        }
        return reversed;
    }

}
