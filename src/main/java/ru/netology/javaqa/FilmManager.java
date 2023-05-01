package ru.netology.javaqa;

public class FilmManager {
    private int maximumLimit = 10;
    private FilmRepository repo;

    public FilmManager() {
    }

      public FilmManager(FilmRepository repo) {
          this.repo = repo;
     }

    public FilmManager(FilmRepository repo, int maximumLimit) {
        this.repo = repo;
        this.maximumLimit = maximumLimit;
    }

    public void add(FilmItem item) {
        repo.save(item);
    }


    public FilmItem[] findAll() {
        FilmItem[] all = repo.findAll();
        return all;
    }

    public FilmItem[] findLast() {
        FilmItem[] all = repo.findAll();
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
