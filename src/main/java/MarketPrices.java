package main.java;

class MarketPrices {
    private static int inflation;
    private static boolean war;
    private double[] prices;

    MarketPrices(Region region, Player player) {
        prices = new double[10];
        if (region.getTechLevel() == TechLevel.PREAG) {
            preagPrices();
        }
        if (region.getTechLevel() == TechLevel.AGRICULTURE) {
            agriculturePrices();
        }
        if (region.getTechLevel() == TechLevel.MEDIEVAL) {
            medivalPrices();
        }
        if (region.getTechLevel() == TechLevel.RENAISSANCE) {
            renaissancePrices();
        }
        if (region.getTechLevel() == TechLevel.INDUSTRIAL) {
            industrialPrices();
        }
        if (region.getTechLevel() == TechLevel.MODERN) {
            modernPrices();
        }
        if (region.getTechLevel() == TechLevel.FUTURISTIC) {
            futeristicPrices();
        }

        if (war) {
            for (int i = 0; i < prices.length; i++) {
                prices[i] *= 1.24;
            }
        }
        if (player.getMerchantPoints() >= 1 && player.getMerchantPoints() <= 2) {
            for (int i = 0; i < prices.length; i++) {
                prices[i] %= 1.24;
            }
        }
        if (player.getMerchantPoints() >= 3 && player.getMerchantPoints() <= 5) {
            for (int i = 0; i < prices.length; i++) {
                prices[i] %= 2.24;
            }
        }
        if (player.getMerchantPoints() >= 6 && player.getMerchantPoints() <= 8) {
            for (int i = 0; i < prices.length; i++) {
                prices[i] %= 3.24;
            }
        }
        if (player.getMerchantPoints() >= 9 && player.getMerchantPoints() <= 10) {
            for (int i = 0; i < prices.length; i++) {
                prices[i] %= 4.24;
            }
        }
        for (int i = 0; i < prices.length; i++) {
            prices[i] = roundNum(prices[i]);
        }
    }
     double[] getPrices() {
        return prices;
    }

    private void preagPrices() {
        int i = 0;
        for (; i < 6; i++) {
            prices[i] =  (Math.random() * 7.23) + 1.50; //food
        }
        for (; i < 7; i++) {
            prices[i] =  (Math.random() * 27) + 15.25; //medicine
        }
        for (; i < 8; i++) {
            prices[i] =  (Math.random() * 28.42) + 18.13; //weapons
        }
        for (; i < 9; i++) {
            prices[i] =  (Math.random() * 15.81) + 9.27; //gold
        }
        for (; i < 10; i++) {
            prices[i] =  (Math.random() * 12.72) + 9.13; //wood
        }
    }
    private void agriculturePrices() {
        int i = 0;
        for (; i < 5; i++) {
            prices[i] = (Math.random() * 13.21) + 5.26; //food
        }
        for (; i < 6; i++) {
            prices[i] = (Math.random() * 50.21) + 40.56; //medicine
        }
        for (; i < 8; i++) {
            prices[i] =  (Math.random() * 32.42) + 27.13; //weapons
        }
        for (; i < 9; i++) {
            prices[i] =  (Math.random() * 15.81) + 9.27; //gold
        }
        for (; i < 10; i++) {
            prices[i] = (Math.random() * 10.32) + 7.23; //wood
        }

    }
    private void medivalPrices() {
        int i = 0;
        for (; i < 3; i++) {
            prices[i] =  (Math.random() * 28.42) + 2.17; //food
        }
        for (; i < 4; i++) {
            prices[i] =  (Math.random() * 40.85) + 2.18; //medicine
        }
        for (; i < 7; i++) {
            prices[i] =  (Math.random() * 22.44) + 10.05; //weapons
        }
        for (; i < 8; i++) {
            prices[i] = (Math.random() * 20.84) + 5.21; //technology
        }
        for (; i < 9; i++) {
            prices[i] =  (Math.random() * 40.18) + 30.62; //gold
        }
        for (; i < 10; i++) {
            prices[i] =  (Math.random() * 9.51) + 6.21; //wood
        }

    }
    private void renaissancePrices() {
        int i = 0;
        for (; i < 2; i++) {
            prices[i] =  (Math.random() * 15.69) + 14.23; //food
        }
        for (; i < 4; i++) {
            prices[i] = (Math.random() * 23.24) + 12.04; //medicine
        }
        for (; i < 6; i++) {
            prices[i] = (Math.random() * 22.41) + 9.15; //weapons
        }
        for (; i < 8; i++) {
            prices[i] = (Math.random() * 40.26) + 18.09; //technology
        }
        for (; i < 9; i++) {
            prices[i] =  (Math.random() * 120.06) + 88.50; //gold
        }
        for (; i < 10; i++) {
            prices[i] = (Math.random() * 10.27) + 8.41; //wood
        }
    }
    private void industrialPrices() {
        int i = 0;
        for (; i < 2; i++) {
            prices[i] =  (Math.random() * 4.12) + 3.17; //food
        }
        for (; i < 4; i++) {
            prices[i] =  (Math.random() * 13.24) + 10.04; //medicine
        }
        for (; i < 6; i++) {
            prices[i] =  (Math.random() * 23.41) + 19.15; //weapons
        }
        for (; i < 8; i++) {
            prices[i] = (Math.random() * 120.26) + 5.09; //technology
        }
        for (; i < 9; i++) {
            prices[i] =  (Math.random() * 500.06) + 420.50; //gold
        }
        for (; i < 10; i++) {
            prices[i] =  (Math.random() * 8.27) + 3.41; //wood
        }
    }
    private void modernPrices() {
        int i = 0;
        for (; i < 2; i++) {
            prices[i] =  (Math.random() * 10.21) + 1.21; //food
        }
        for (; i < 4; i++) {
            prices[i] =   (Math.random() * 75.12) + 8.14; //medicine
        }
        for (; i < 6; i++) {
            prices[i] =   (Math.random() * 30.21) + 27.11; //weapons
        }
        for (; i < 8; i++) {
            prices[i] =  (Math.random() * 50.62) + 24.13; //technology
        }
        for (; i < 9; i++) {
            prices[i] =   (Math.random() * 900.21) + 600.12; //gold
        }
        for (; i < 10; i++) {
            prices[i] =   (Math.random() * 7.27) + 1.41; //wood
        }
    }
    private void futeristicPrices() {
        int i = 0;
        for (; i < 2; i++) {
            prices[i] =  (Math.random() * 20.21) + 5.21; //food
        }
        for (; i < 4; i++) {
            prices[i] =   (Math.random() * 99.12) + 65.14; //medicine
        }
        for (; i < 6; i++) {
            prices[i] =  (Math.random() * 200.21) + 150.11; //weapons
        }
        for (; i < 8; i++) {
            prices[i] =  (Math.random() * 500.62) + 420.13; //technology
        }
        for (; i < 9; i++) {
            prices[i] =  (Math.random() * 2000.21) + 1200.12; //gold
        }
        for (; i < 10; i++) {
            prices[i] =   (Math.random() * 562.27) + 400.41; //wood
        }
    }
    private double roundNum(double num) {
        return Math.round(num * 100.0) / 100.0;
    }
}
