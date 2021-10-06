package main.java;

public class ItemAmount {
    private int[] itemAmount;

    public ItemAmount(String[] items, int[] resources, Region region, Player player) {
        itemAmount = new int[10];
        if (region.getTechLevel() == TechLevel.PREAG) {
            preagAmt();
        }
        if (region.getTechLevel() == TechLevel.AGRICULTURE) {
            agricultureAmt();
        }
        if (region.getTechLevel() == TechLevel.MEDIEVAL) {
            medivalAmt();
        }
        if (region.getTechLevel() == TechLevel.RENAISSANCE) {
            renaissanceAmt();
        }
        if (region.getTechLevel() == TechLevel.INDUSTRIAL) {
            industrialAmt();
        }
        if (region.getTechLevel() == TechLevel.MODERN) {
            modernAmt();
        }
        if (region.getTechLevel() == TechLevel.FUTURISTIC) {
            futeristicAmt();
        }
    }
    public int[] getItemAmount() {
        return itemAmount;
    }

    private void preagAmt() {
        int i = 0;
        for (; i < 6; i++) {
            itemAmount[i] =  (int) (Math.random() * 8) + 1; //food
        }
        for (; i < 7; i++) {
            itemAmount[i] =  (int) (Math.random() * 9) + 1; //medicine
        }
        for (; i < 8; i++) {
            itemAmount[i] =  (int) (Math.random() * 12) + 1; //weapons
        }
        for (; i < 9; i++) {
            itemAmount[i] =  (int) (Math.random() * 10) + 1; //gold
        }
        for (; i < 10; i++) {
            itemAmount[i] = (int) (Math.random() * 14) + 1; //wood
        }
    }
    private void agricultureAmt() {
        int i = 0;
        for (; i < 5; i++) {
            itemAmount[i] = (int) (Math.random() * 50) + 1; //food
        }
        for (; i < 6; i++) {
            itemAmount[i] = (int) (Math.random() * 10) + 1; //medicine
        }
        for (; i < 8; i++) {
            itemAmount[i] =  (int) (Math.random() * 10) + 1; //weapons
        }
        for (; i < 9; i++) {
            itemAmount[i] = (int) (Math.random() * 20) + 1; //gold
        }
        for (; i < 10; i++) {
            itemAmount[i] = (int) (Math.random() * 10) + 1; //wood
        }
    }
    private void medivalAmt() {
        int i = 0;
        for (; i < 3; i++) {
            itemAmount[i] =  (int) (Math.random() * 70) + 1; //food
        }
        for (; i < 4; i++) {
            itemAmount[i] =  (int) (Math.random() * 20) + 1; //medicine
        }
        for (; i < 7; i++) {
            itemAmount[i] =  (int) (Math.random() * 30) + 1; //weapons
        }
        for (; i < 8; i++) {
            itemAmount[i] = (int) (Math.random() * 5) + 1; //technology
        }
        for (; i < 9; i++) {
            itemAmount[i] =  (int) (Math.random() * 40) + 1; //gold
        }
        for (; i < 10; i++) {
            itemAmount[i] =  (int) (Math.random() * 100) + 1; //wood
        }

    }
    private void renaissanceAmt() {
        int i = 0;
        for (; i < 2; i++) {
            itemAmount[i] =  (int) (Math.random() * 100) + 1; //food
        }
        for (; i < 4; i++) {
            itemAmount[i] = (int) (Math.random() * 20) + 1; //medicine
        }
        for (; i < 6; i++) {
            itemAmount[i] = (int) (Math.random() * 20) + 1; //weapons
        }
        for (; i < 8; i++) {
            itemAmount[i] = (int) (Math.random() * 50) + 1; //technology
        }
        for (; i < 9; i++) {
            itemAmount[i] =  (int) (Math.random() * 80) + 1; //gold
        }
        for (; i < 10; i++) {
            itemAmount[i] = (int) (Math.random() * 110) + 1; //wood
        }
    }
    private void industrialAmt() {
        int i = 0;
        for (; i < 2; i++) {
            itemAmount[i] =  (int) (Math.random() * 200) + 1; //food
        }
        for (; i < 4; i++) {
            itemAmount[i] =  (int) (Math.random() * 50) + 1; //medicine
        }
        for (; i < 6; i++) {
            itemAmount[i] =  (int) (Math.random() * 80) + 1; //weapons
        }
        for (; i < 8; i++) {
            itemAmount[i] = (int) (Math.random() * 100) + 1; //technology
        }
        for (; i < 9; i++) {
            itemAmount[i] =  (int) (Math.random() * 100) + 1; //gold
        }
        for (; i < 10; i++) {
            itemAmount[i] =  (int) (Math.random() * 200) + 1; //wood
        }
    }
    private void modernAmt() {
        int i = 0;
        for (; i < 2; i++) {
            itemAmount[i] =  (int) (Math.random() * 400) + 1; //food
        }
        for (; i < 4; i++) {
            itemAmount[i] =   (int) (Math.random() * 50) + 1; //medicine
        }
        for (; i < 6; i++) {
            itemAmount[i] =   (int) (int) (Math.random() * 80) + 1; //weapons
        }
        for (; i < 8; i++) {
            itemAmount[i] =  (int) (Math.random() * 90) + 1; //technology
        }
        for (; i < 9; i++) {
            itemAmount[i] =   (int) (Math.random() * 600) + 1; //gold
        }
        for (; i < 10; i++) {
            itemAmount[i] =   (int) (Math.random() * 1000) + 1; //wood
        }
    }
    private void futeristicAmt() {
        int i = 0;
        for (; i < 2; i++) {
            itemAmount[i] =  (int) (Math.random() * 5000) + 1; //food
        }
        for (; i < 4; i++) {
            itemAmount[i] =   (int) (Math.random() * 80) + 1; //medicine
        }
        for (; i < 6; i++) {
            itemAmount[i] = (int) (Math.random() * 150) + 1; //weapons
        }
        for (; i < 8; i++) {
            itemAmount[i] =  (int) (Math.random() * 500) + 1; //technology
        }
        for (; i < 9; i++) {
            itemAmount[i] =  (int) (Math.random() * 1000) + 1; //gold
        }
        for (; i < 10; i++) {
            itemAmount[i] =   (int) (Math.random() * 100) + 1; //wood
        }
    }
}
