// Album.java
// From Classic Computer Science Problems in Java Chapter 6
// Copyright 2020 David Kopec
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package org.example.laba1;

import java.util.ArrayList;
import java.util.List;

public class Album extends DataPoint {
    private String name;
    private int year;

    public Album(String name, int year, double length, double tracks) {
        super(List.of(length, tracks));
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + year + ")";
    }

    public static void main(String[] args) {
        List<Album> albums = getAlbums();

        int counter = 0;
        int iterations = 100;

        for (int i = 0; i < iterations; i++) {
            List<KMeans<Album>.Cluster> clusters = getClusters(2, albums);
            for (KMeans<Album>.Cluster cluster : clusters) {
                if (cluster.points.size() == 1 && cluster.points.get(0).getName().equals("HIStory: Past, Present and Future, Book I")) {
                    counter++;
                    break;
                }
            }
        }
        System.out.printf("Iterations: %d\n", iterations);
        System.out.printf("Longest album is alone in the cluster: %d\n", counter);
        System.out.printf("%d/%d\n", counter, iterations);
        /*for (int i = 0; i < 10; i++) {
            List<KMeans<Album>.Cluster> clusters = getClusters(2, albums);

            for (int clusterIndex = 0; clusterIndex < clusters.size();
                 clusterIndex++) {
                System.out.printf("Cluster %d Avg Length %f Avg Tracks %f: %s%n",
                        clusterIndex, clusters.get(clusterIndex).centroid.dimensions.get(0),
                        clusters.get(clusterIndex).centroid.dimensions.get(1),
                        clusters.get(clusterIndex).points);
            }
            System.out.println("\n\n");
        }*/
    }

    public static List<KMeans<Album>.Cluster> getClusters(int iterations, List<Album> albums) {
        KMeans<Album> kmeans = new KMeans<>(iterations, albums);
        return kmeans.run(100);
    }

    private static List<Album> getAlbums() {
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
        return albums;
    }

    public String getName() {
        return this.name;
    }
}