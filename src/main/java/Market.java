package main.java;

public class Market {
    private int gold1;
    private int wood1;
    private MarketItems marketItems;
    private String[] items;
    private int[] resources;
    private String[] food;
    private String[] weapons;
    private String[] medicine;
    private String[] tech;
    private Region region;
    private int numItems;

    public Market(Region region) {
        numItems = 8;
        this.region = region;
        marketItems = new MarketItems(region);
        setItems();
    }

    private void setItems() {
        if (region.getTechLevel() == TechLevel.PREAG) {
            this.items = new String[numItems];
            marketItems.setNumItems(6);
            food = marketItems.getFood();
            System.arraycopy(food, 0, this.items, 0, 6);
            marketItems.setNumItems(1);
            medicine = marketItems.getMedicine();
            System.arraycopy(medicine, 0, this.items, 6, 1);
            marketItems.setNumItems(1);
            weapons = marketItems.getWeapons();
            System.arraycopy(weapons, 0, this.items, 7, 1);

            this.resources = new int[2];
            this.resources[0] = gold(1);
            this.resources[1] = wood(1);

        }
        if (region.getTechLevel() == TechLevel.AGRICULTURE) {
            this.items = new String[numItems];
            marketItems.setNumItems(5);
            food = marketItems.getFood();
            System.arraycopy(food, 0, this.items, 0, 5);
            marketItems.setNumItems(1);
            medicine = marketItems.getMedicine();
            System.arraycopy(medicine, 0, this.items, 5, 1);
            marketItems.setNumItems(2);
            weapons = marketItems.getWeapons();
            System.arraycopy(weapons, 0, this.items, 6, 2);

            this.resources = new int[2];
            this.resources[0] = gold(2);
            this.resources[1] = wood(2);

        }
        if (region.getTechLevel() == TechLevel.MEDIEVAL) {
            this.items = new String[numItems];
            marketItems.setNumItems(3);
            food = marketItems.getFood();
            System.arraycopy(food, 0, this.items, 0, 3);
            marketItems.setNumItems(1);
            medicine = marketItems.getMedicine();
            System.arraycopy(medicine, 0, this.items, 3, 1);
            marketItems.setNumItems(3);
            weapons = marketItems.getWeapons();
            System.arraycopy(weapons, 0, this.items, 4, 3);
            marketItems.setNumItems(1);
            tech = marketItems.getWeapons();
            System.arraycopy(tech, 0, this.items, 7, 1);

            this.resources = new int[2];
            this.resources[0] = gold(3);
            this.resources[1] = wood(3);

        }
        if (region.getTechLevel() == TechLevel.RENAISSANCE) {
            this.items = new String[numItems];
            marketItems.setNumItems(2);
            food = marketItems.getFood();
            System.arraycopy(food, 0, this.items, 0, 2);
            marketItems.setNumItems(2);
            medicine = marketItems.getMedicine();
            System.arraycopy(medicine, 0, this.items, 2, 2);
            marketItems.setNumItems(2);
            weapons = marketItems.getWeapons();
            System.arraycopy(weapons, 0, this.items, 4, 2);
            marketItems.setNumItems(2);
            tech = marketItems.getWeapons();
            System.arraycopy(tech, 0, this.items, 6, 2);

            this.resources = new int[2];
            this.resources[0] = gold(4);
            this.resources[1] = wood(4);

        }
        if (region.getTechLevel() == TechLevel.INDUSTRIAL) {
            this.items = new String[numItems];
            marketItems.setNumItems(1);
            food = marketItems.getFood();
            System.arraycopy(food, 0, this.items, 0, 1);
            marketItems.setNumItems(2);
            medicine = marketItems.getMedicine();
            System.arraycopy(medicine, 0, this.items, 1, 2);
            marketItems.setNumItems(1);
            weapons = marketItems.getWeapons();
            System.arraycopy(weapons, 0, this.items, 3, 1);
            marketItems.setNumItems(4);
            tech = marketItems.getWeapons();
            System.arraycopy(tech, 0, this.items, 4, 4);

            this.resources = new int[2];
            this.resources[0] = gold(5);
            this.resources[1] = wood(5);

        }
        if (region.getTechLevel() == TechLevel.MODERN) {
            this.items = new String[numItems];
            marketItems.setNumItems(1);
            food = marketItems.getFood();
            System.arraycopy(food, 0, this.items, 0, 1);
            marketItems.setNumItems(3);
            medicine = marketItems.getMedicine();
            System.arraycopy(medicine, 0, this.items, 1, 3);
            marketItems.setNumItems(1);
            weapons = marketItems.getWeapons();
            System.arraycopy(weapons, 0, this.items, 4, 1);
            marketItems.setNumItems(3);
            tech = marketItems.getWeapons();
            System.arraycopy(tech, 0, this.items, 6, 2);

            this.resources = new int[2];
            this.resources[0] = gold(6);
            this.resources[1] = wood(6);

        }
        if (region.getTechLevel() == TechLevel.FUTURISTIC) {
            this.items = new String[numItems];
            marketItems.setNumItems(1);
            food = marketItems.getFood();
            System.arraycopy(food, 0, this.items, 0, 1);
            marketItems.setNumItems(1);
            medicine = marketItems.getMedicine();
            System.arraycopy(medicine, 0, this.items, 1, 1);
            marketItems.setNumItems(2);
            weapons = marketItems.getWeapons();
            System.arraycopy(weapons, 0, this.items, 2, 2);
            marketItems.setNumItems(4);
            tech = marketItems.getWeapons();
            System.arraycopy(tech, 0, this.items, 4, 4);


            this.resources = new int[2];
            this.resources[0] = gold(7);
            this.resources[1] = wood(7);
        }


    }

    public String[] getItems() {
        return this.items;
    }

    public int[] getResources() {
        return this.resources;
    }

    private int gold(int techInt) {
        if (techInt == 1) {
            gold1 = 500;
            return gold1;
        }
        if (techInt == 2) {
            gold1 = 900;
            return gold1;
        }
        if (techInt == 3) {
            gold1 = 3000;
            return gold1;
        }
        if (techInt == 4) {
            gold1 = 10000;
            return gold1;
        }
        if (techInt == 5) {
            gold1 = 50000;
            return gold1;
        }
        if (techInt == 6) {
            gold1 = 90000;
            return gold1;
        }
        if (techInt == 7) {
            gold1 = 100000;
            return gold1;
        }
        return 0;
    }
    private int wood(int techInt) {
        if (techInt == 1) {
            wood1 = 600;
            return wood1;
        }
        if (techInt == 2) {
            wood1 = 800;
            return wood1;
        }
        if (techInt == 3) {
            wood1 = 900;
            return wood1;
        }
        if (techInt == 4) {
            wood1 = 1000;
            return wood1;
        }
        if (techInt == 5) {
            wood1 = 4000;
            return wood1;
        }
        if (techInt == 6) {
            wood1 = 5000;
            return wood1;
        }
        if (techInt == 7) {
            wood1 = 200;
            return wood1;
        }
        return 0;
    }
}
