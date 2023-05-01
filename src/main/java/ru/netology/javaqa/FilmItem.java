package ru.netology.javaqa;

public class FilmItem {
    private int id;
    private String image;
    private String nameFilm;
    private String genreFilm;
    private int release;

    public FilmItem(int id, String image, String nameFilm, String genreFilm, int release) {
        this.id = id;
        this.image = image;
        this.nameFilm = nameFilm;
        this.genreFilm = genreFilm;
        this.release = release;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getNameFilm() {
        return nameFilm;
    }

    public String getGenreFilm() {
        return genreFilm;
    }

    public int getRelease() {
        return release;
    }
}
