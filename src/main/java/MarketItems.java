package main.java;

public class MarketItems {
    private Region region;
    private String[] items;
    private String[] food;
    private String[] weapons;
    private String[] medicine;
    private String[] tech;
    private int[] randomNum;
    private int x;
    public MarketItems(Region region) {
        this.region = region;
        initItems();
    }
    public void setNumItems(int numItems) {
        this.randomNum = new int[numItems];
    }
    private void initItems() {
        if (region.getTechLevel() == TechLevel.PREAG) {
            food = new String[]{"Gagh", "Spoo", "Lembas",
                "Zirg", "Pleps", "Glac"};
            weapons = new String[]{"Sharp Stick", "Spear",
                "Club", "w4", "w5", "w6"};
            medicine = new String[]{"doll", "enchanted sticks",
                "protective amulet", "m4", "m5", "m6"};
            tech = new String[]{"t1", "t2", "t3", "t4", "t5", "t6"};
        }
        if (region.getTechLevel() == TechLevel.AGRICULTURE) {
            food = new String[]{"Liff", "Crats", "Larth", "Venix", "Bln"};
            weapons = new String[]{"Traps", "Slingshot", "Knife", "4", "5", "6"};
            medicine = new String[]{"Venith Berries", "Lych Leaves",
                "Acadia Bark", "m4", "m5", "m6"};
            tech = new String[]{"t1", "t2", "t3", "t4", "t5", "t6"};
        }
        if (region.getTechLevel() == TechLevel.MEDIEVAL) {
            food = new String[]{"Grek", "Maldon", "Liss", "Kan", "Tar"};
            weapons = new String[]{"Catapult", "Mace", "Sword", "4", "5", "6"};
            medicine = new String[]{"Bano", "Licthat", "Xinto", "m4", "m5", "m6"};
            tech = new String[]{"t1", "t2", "t3", "t4", "t5", "t6"};
        }
        if (region.getTechLevel() == TechLevel.RENAISSANCE) {
            food = new String[]{"Blantrossa", "Xitario", "Trancar"};
            weapons = new String[]{"Rapier", "Dagger", "Mace", "4", "5", "6"};
            medicine = new String[]{"Nalit Tablets", "Vach", "Lembas", "m4", "m5", "m6"};
            tech = new String[]{"t1", "t2", "t3", "t4", "t5", "t6"};
        }
        if (region.getTechLevel() == TechLevel.INDUSTRIAL) {
            food = new String[]{"Vis Nex", "Harthcul", "Vactur", "Jana", "Onato"};
            weapons = new String[]{"Toxic Gas", "Rifle", "Grenade", "4", "5", "6"};
            medicine = new String[]{"Otho's Medicinal Water",
                "Jerithan", "Katatan", "m4", "m5", "m6"};
            tech = new String[]{"t1", "t2", "t3", "t4", "t5", "t6"};
        }
        if (region.getTechLevel() == TechLevel.MODERN) {
            food = new String[]{"Lennion", "Unary", "Histan", "Glenine", "Rith" };
            weapons = new String[]{"Nuke", "Machine Guns", "Hand Cannon", "4", "5", "6"};
            medicine = new String[]{"Tylin", "Aspirtra", "Vanix", "m4", "m5", "m6"};
            tech = new String[]{"t1", "t2", "t3", "t4", "t5", "t6"};
        }
        if (region.getTechLevel() == TechLevel.FUTURISTIC) {
            food = new String[]{"Clathus", "Ananton", "Urthran"};
            weapons = new String[]{"Phaser", "Neurogas", "Plasma Shield", "4", "5", "6"};
            medicine = new String[]{"Electropuler", "Macnivat", "Lignon", "m4", "m5", "m6"};
            tech = new String[]{"t1", "t2", "t3", "t4", "t5", "t6"};
        }
    }

     String[] getFood() {
        items = new String[randomNum.length];
        for (int i = 0; i < randomNum.length; i++) {
            x = (int) (Math.random() * food.length - 1) + 1;
            for (int j = 0; j < i; j++) {
                if (x == randomNum[j]) {
                    x = (int) (Math.random() * food.length - 1) + 1;
                    j = 0;
                } else {
                    randomNum[i] = x;

                }
            }
        }
        for (int i = 0; i < randomNum.length; i++) {
            items[i] = food[randomNum[i]];
        }
        return items;
    }
    public String[] getMedicine() {
        items = new String[randomNum.length];
        for (int i = 0; i < randomNum.length; i++) {
            x = (int) (Math.random() * medicine.length - 1) + 1;
            for (int j = 0; j < i; j++) {
                if (x == randomNum[j]) {
                    x = (int) (Math.random() * medicine.length - 1) + 1;
                    j = 0;
                } else {
                    randomNum[i] = x;

                }
            }
        }
        for (int i = 0; i < randomNum.length; i++) {
            items[i] = medicine[randomNum[i]];
        }
        return items;
    }
    public String[] getWeapons() {
        items = new String[randomNum.length];
        for (int i = 0; i < randomNum.length; i++) {
            x = (int) (Math.random() * weapons.length - 1) + 1;
            for (int j = 0; j < i; j++) {
                if (x == randomNum[j]) {
                    x = (int) (Math.random() * weapons.length - 1) + 1;
                    j = 0;
                } else {
                    randomNum[i] = x;

                }
            }
        }
        for (int i = 0; i < randomNum.length; i++) {
            items[i] = weapons[randomNum[i]];
        }
        return items;
    }
    public String[] getTech() {
        items = new String[randomNum.length];
        for (int i = 0; i < randomNum.length; i++) {
            x = (int) (Math.random() * tech.length - 1) + 1;
            for (int j = 0; j < i; j++) {
                if (x == randomNum[j]) {
                    x = (int) (Math.random() * tech.length - 1) + 1;
                    j = 0;
                } else {
                    randomNum[i] = x;

                }
            }
        }
        for (int i = 0; i < tech.length; i++) {
            items[i] = tech[randomNum[i]];
        }
        return items;
    }
}
