package main.java;

import java.util.HashSet;

public class Universe {
    private static final Universe SINGLE_INSTANCE = new Universe();
    private HashSet<Region> set;
    private String[] names;

    private Universe() {
        names = new String[]{"Mirzam", "Hadir", "Cursa", 
            "Nihal", "Achernar", "Nunki", "Menkent", "Izar", "Alphekka", "Yildun"};
        set = new HashSet<Region>();
        while (set.size() < 10) {
            int x = (int) (Math.random() * 401 - 200);
            int y = (int) (Math.random() * 401 - 200);
            Region reg = new Region(x, y, names[set.size()], TechLevel.getRandomTechLevel());
            set.add(reg);
        }
    }

    /**
     * Getter method for set of regions
     *
     * @return set of regions
     */
    public HashSet<Region> getSet() {
        return set;
    }

    public static Universe getInstance() {
        return SINGLE_INSTANCE;
    }
}