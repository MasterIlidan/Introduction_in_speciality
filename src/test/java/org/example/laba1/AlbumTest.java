package org.example.laba1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlbumTest {

    @Test
    void getClusters() {
        final int points_size = 1;
        final String name = "HIStory: Past, Present and Future, Book I";
        double expected = 0.75;
        int actual = 0;
        int countOfRuns = 100;
        boolean testPassed = false;

        List<Album> albums = new ArrayList<>();
        albums.add(new Album("Got to Be There", 1972, 35.45, 10));
        albums.add(new Album("Ben", 1972, 31.31, 10));
        albums.add(new Album("Music & Me", 1973, 32.09, 10));
        albums.add(new Album("Forever, Michael", 1975, 33.36, 10));
        albums.add(new Album("Off the Wall", 1979, 42.28, 10));
        albums.add(new Album("Thriller", 1982, 42.19, 9));
        albums.add(new Album("Bad", 1987, 48.16, 10));
        albums.add(new Album("Dangerous", 1991, 77.03, 14));
        albums.add(new Album("HIStory: Past, Present and Future, Book I", 1995,
                148.58, 30));
        albums.add(new Album("Invincible", 2001, 77.05, 16));

        for (int run = 0; run < countOfRuns; run++) {
            List<KMeans<Album>.Cluster> clusters = Album.getClusters(2, albums);

            for (KMeans<Album>.Cluster cluster : clusters) {
                if (cluster.points.size() == points_size && cluster.points.get(0).getName().equals(name)) {
                    actual++;
                    break;
                }
            }
        }

        System.out.printf("Count of runs: %d\n", countOfRuns);
        System.out.printf("Success: %f percent\n", (double) actual / countOfRuns * 100);

        if ((double) actual / countOfRuns > expected) {
            testPassed = true;
        }


        assertTrue(testPassed);
    }
}