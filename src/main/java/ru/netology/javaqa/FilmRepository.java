package ru.netology.javaqa;

public class FilmRepository {

    private FilmItem[] items = new FilmItem[0];

    public void save(FilmItem item) {
        FilmItem[] tmp = new FilmItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public FilmItem[] findAll() {
        return items;
    }

    public FilmItem[] findById(int id) {
        FilmItem[] tmp = new FilmItem[1];
        tmp = null;
        for (FilmItem item : items) {
            if (item.getId() == id) {
                FilmItem[] tpm = {item};
                return tpm;
            }
        }
        return tmp;
    }

    public void removeById(int id) {
        FilmItem[] tmp = new FilmItem[items.length - 1];
        int copyToIndex = 0;
        for (FilmItem item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }


    public void removeAll() {
        items = new FilmItem[0];
    }

}
