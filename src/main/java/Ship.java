package main.java;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Iterator;

public class Ship {
    private LinkedHashSet<Ship> shipSet;
    private String name;
    private double fuelAmount;
    private int cargo;
    private int health;
    private LinkedList<Item> cargoList;
    private Item item;
    private int initHealth;

    public Ship() {
        String[] types = new String[]{"Apollo", "Huntress", "Executor",
            "Manticore", "SSE Big Daddy"};
        shipSet = new LinkedHashSet<Ship>();
        while (shipSet.size() < 5) {
            Ship ship = new Ship(types[shipSet.size()]);
            shipSet.add(ship);
        }
    }

    private Ship(String name) {
        cargoList = new LinkedList<Item>();
        this.name = name;
        switch (name) {
        case "Apollo":
            this.fuelAmount = 100;
            this.health = 1000;
            this.cargo = 10;
            this.initHealth = health;
            break;
        case "Huntress":
            this.fuelAmount = 150;
            this.health = 1500;
            this.cargo = 15;
            this.initHealth = health;
            break;
        case "Executor":
            this.fuelAmount = 250;
            this.health = 2000;
            this.cargo = 20;
            this.initHealth = health;
            break;
        case "Manticore":
            this.fuelAmount = 300;
            this.health = 2500;
            this.cargo = 25;
            this.initHealth = health;
            break;
        case "SSE Big Daddy":
            this.fuelAmount = 500;
            this.health = 3000;
            this.cargo = 30;
            this.initHealth = health;
            break;
        default:
        }
    }

    public LinkedHashSet<Ship> getShipSet() {
        return this.shipSet;
    }

    public Ship getStartShip() {
        Ship startShip = null;
        // iterates once to get the first ship
        for (Ship ship : shipSet) {
            startShip = ship;
            break;
        }
        return startShip;
    }

    public void travel(double fuelCost) {
        this.fuelAmount -= fuelCost;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }
    public int getInitHealth() {
        return initHealth;
    }

    public int getCargo() {
        return this.cargo;
    }
    public void addCargo(String name,  double price, int amount) {
        item = new Item(name, price, amount);
        cargoList.add(item);


        Iterator it = cargoList.iterator();
        while (it.hasNext()) {
            Item x = (Item) it.next();
        }


    }
    public void addCargo(Item item) {
        cargoList.add(item);

    }
    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
    public LinkedList<Item> getCargoList() {
        return this.cargoList;
    }

    public void setCargoList(LinkedList<Item> list) {
        this.cargoList = list;
    }
    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return this.name;
    }

    public Item removeSingleItem() {
        return this.cargoList.removeFirst();
    }

    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Ship)) {
            return false;
        }

        Ship s = (Ship) o;
        // if region has the same attributes, then they are equal
        return name.equals(s.getName())
                && health == ((Ship) o).health
                && fuelAmount == ((Ship) o).fuelAmount
                && cargo == ((Ship) o).getCargo();
    }
}
