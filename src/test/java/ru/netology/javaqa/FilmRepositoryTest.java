package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FilmRepositoryTest {

    FilmItem item1 = new FilmItem(15, "shrek.com", "Shrek", "cartoon", 18);
    FilmItem item2 = new FilmItem(1, "it.com", "It", "horror", 19);
    FilmItem item3 = new FilmItem(2, "yesman.com", "Yesman", "comedy", 20);
    FilmItem item4 = new FilmItem(16, "shrek2.com", "Shrek 2", "cartoon", 19);
    FilmItem item5 = new FilmItem(9, "three_steps_above_heaven.com", "Tres Metros Sobre el cielo", "drama", 28);
    FilmItem item6 = new FilmItem(3, "dumb_and_dumber.com", "Dumb and Dumber", "comedy", 6);
    FilmItem item7 = new FilmItem(4, "zodiac.com", "Zodiac", "detective", 1);
    FilmItem item8 = new FilmItem(5, "heirs.kd", "The Heirs", "kdrama", 12);
    FilmItem item9 = new FilmItem(29, "guardians_of_the_Galaxy.com", "Guardians of the Galaxy", "sci-fi", 21);
    FilmItem item10 = new FilmItem(11, "lalalala.com", "Lala Land", "musical", 30);
    FilmItem item11 = new FilmItem(27, "curiosa.ht", "Curiosa", "historical", 31);
    FilmItem item12 = new FilmItem(14, "the-Gentlemen.com", "The Gentlemen", "action", 20);

    FilmRepository repo = new FilmRepository();

    @BeforeEach
    public void setup() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);
        repo.save(item7);
        repo.save(item8);
        repo.save(item9);
        repo.save(item10);
        repo.save(item11);
        repo.save(item12);
    }

    @Test
    public void shouldSave(){

        FilmItem[] expected = {item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12};
        FilmItem[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.removeById(item8.getId());

        FilmItem[] expected = {item1, item2, item3, item4, item5, item6, item7, item9, item10, item11, item12};
        FilmItem[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnsAnObjectById() {
        repo.findById(100);

        FilmItem[] expected = null;
        FilmItem[] actual = repo.findById(100);

        Assertions.assertArrayEquals(expected, actual);

        repo.findById(item8.getId());

        FilmItem[] expected1 = {item8};
        FilmItem[] actual1 = repo.findById(item8.getId());

        Assertions.assertArrayEquals(expected1, actual1);
    }

    @Test
    public void shouldRemoveAll() {
        repo.removeAll();

        FilmItem[] expected = new FilmItem[0];
        FilmItem[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
