package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;


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

    FilmRepository repo = new FilmRepository();
    FilmManager manager = new FilmManager(repo);



    @BeforeEach
    public void setup() {
        manager.add(item1);
        manager.add(item3);
        manager.add(item2);
        manager.add(item5);
        manager.add(item4);
        manager.add(item7);
        manager.add(item6);
        manager.add(item8);
        manager.add(item9);
        manager.add(item10);
        manager.add(item11);
        manager.add(item12);

    }


    @Test
    public void shouldAddNewFilms() {

        FilmItem[] expected = {item1, item3, item2, item5, item4, item7, item6, item8, item9, item10, item11, item12};
        FilmItem[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOutputTheLatestAddedFilmsInReverseOrder() {
        FilmManager manager1 = new FilmManager(repo,5);

        FilmItem[] expected = {item12, item11, item10, item9, item8};
        FilmItem[] actual = manager1.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    FilmRepository repo1 = Mockito.mock(FilmRepository.class);

    FilmManager manager1 = new FilmManager(repo1);

    @Test
    public void shouldAddNewFilmsMockito() {
        FilmItem[] items = {item12, item11, item10, item9, item8, item7, item6, item5, item4, item3, item2, item1};
        doReturn(items).when(repo1).findAll();

        FilmItem[] expected = {item12, item11, item10, item9, item8, item7, item6, item5, item4, item3, item2, item1};
        FilmItem[] actual = manager1.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOutputTheLatestAddedFilmsInReverseOrderMockito() {
        FilmManager manager1 = new FilmManager(repo1,5);
        FilmItem[] items = {item12, item11, item10, item9, item8, item7, item6, item5, item4, item3, item2, item1};
        doReturn(items).when(repo1).findAll();

        FilmItem[] expected = {item1, item2, item3, item4, item5};
        FilmItem[] actual = manager1.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }



}
