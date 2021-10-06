package main.java;


public class Region {
    private int x;
    private int y;
    private TechLevel techLevel;
    private String name;
    private int[] backgroundColor;

    public Region(int x, int y,  String name, TechLevel techLevel) {
        this.x = x;
        this.y = y;
        this.techLevel = techLevel;
        this.name = name;
        randomizeBackground();
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return this.y;
    }

    public void setTechLevel(TechLevel techLevel) {
        this.techLevel = techLevel;
    }

    public TechLevel getTechLevel() {
        return this.techLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int manhattanDistance(Region region) {
        return Math.abs(this.x - region.getX()) + Math.abs(this.y - region.getY());
    }

    /**
     * Randomizes background color upon the construction of a region
     */
    private void randomizeBackground() {
        backgroundColor = new int[3];
        backgroundColor[0] = (int) (Math.random() * 256);
        backgroundColor[1] = (int) (Math.random() * 256);
        backgroundColor[2] = (int) (Math.random() * 256);
    }

    public int[] getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Region)) {
            return false;
        }

        Region r = (Region) o;
        // if region has the same coordinates, then they are equal
        return manhattanDistance(r) == 0;
    }

    @Override
    public int hashCode() {
        return 1000 * this.x + this.y;
    }
}