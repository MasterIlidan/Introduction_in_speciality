package org.example.laba1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataPointTest {

    @Test
    void distance() {
        List<Album> albums = new ArrayList<>();
        albums.add(new Album("Got to Be There", 1972, 35.45, 10));
        albums.add(new Album("Test album", 2000, 1d, 2d));

        System.out.println("Album 1: " + albums.get(0));
        System.out.println("Album 2: " + albums.get(1));

        double expected = 35.366686302225155;
        double result = albums.get(0).distance(albums.get(1));

        System.out.println("Calculating distance");
        System.out.println("Expected value: " + expected);
        System.out.println("Result value: " + result);
        assertEquals(expected, result);
    }
}