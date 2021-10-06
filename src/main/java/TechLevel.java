package main.java;

import java.util.Random;

public enum TechLevel {
    PREAG, AGRICULTURE, MEDIEVAL, RENAISSANCE, INDUSTRIAL, MODERN, FUTURISTIC;

    public static TechLevel getRandomTechLevel() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}