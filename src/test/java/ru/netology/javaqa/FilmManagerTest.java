package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmManagerTest {


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


    @Test
    public void shouldAddNewFilms() {
        FilmManager manager = new FilmManager();
        manager.save(item1);
        manager.save(item2);
        manager.save(item3);
        manager.save(item4);
        manager.save(item5);
        manager.save(item6);
        manager.save(item7);
        manager.save(item10);

        FilmItem[] expected = {item1, item2, item3, item4, item5, item6, item7, item10};
        FilmItem[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldKeepInOrderOfAddition() {
        FilmManager manager = new FilmManager();
        manager.save(item3);
        manager.save(item1);
        manager.save(item2);
        manager.save(item8);
        manager.save(item9);
        manager.save(item11);
        manager.save(item12);

        FilmItem[] expected = {item3, item1, item2, item8, item9, item11, item12};
        FilmItem[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOutputTheLatestAddedFilmsInReverseOrderWhenMoreFilms(){
        FilmManager manager = new FilmManager(5);
        manager.save(item3);
        manager.save(item1);
        manager.save(item2);
        manager.save(item8);
        manager.save(item9);
        manager.save(item11);
        manager.save(item12);

        FilmItem[] expected = {item12, item11, item9, item8, item2};
        FilmItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldOutputTheLatestAddedFilmsInReverseOrderWhenEqualLimit(){
        FilmManager manager = new FilmManager(5);
        manager.save(item2);
        manager.save(item8);
        manager.save(item9);
        manager.save(item11);
        manager.save(item12);

        FilmItem[] expected = {item12, item11, item9, item8, item2};
        FilmItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldOutputTheLatestAddedFilmsInReverseOrderWhenfewerLessLimit(){
        FilmManager manager = new FilmManager(5);
        manager.save(item11);
        manager.save(item12);

        FilmItem[] expected = {item12, item11};
        FilmItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }
}
