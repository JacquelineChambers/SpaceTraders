package main.java;

import javax.swing.*;

public class CargoDispScreen {
    private JPanel cargoPanel;
    private JLabel cargo;
    private JLabel cargo0;
    private JLabel cargo1;
    private JLabel cargo2;
    private JLabel cargo3;
    private JLabel cargo4;
    private JLabel cargo5;
    private JLabel cargo6;
    private JLabel cargo7;
    private JLabel cargo8;
    private JLabel cargo9;
    private JLabel cargo10;
    private JLabel[] cargoArray;

    public CargoDispScreen() {
        cargoArray = new JLabel[11];
        cargoPanel = new JPanel();
        cargo0 = new JLabel();
        cargo1 = new JLabel();
        cargo2 = new JLabel();
        cargo3 = new JLabel();
        cargo4 = new JLabel();
        cargo5 = new JLabel();
        cargo6 = new JLabel();
        cargo7 = new JLabel();
        cargo8 = new JLabel();
        cargo9 = new JLabel();
        cargo10 = new JLabel();

        cargoArray();

    }
    private void cargoArray() {
        cargoArray[0] = cargo0;
        cargoArray[1] = cargo1;
        cargoArray[2] = cargo2;
        cargoArray[3] = cargo3;
        cargoArray[4] = cargo4;
        cargoArray[5] = cargo5;
        cargoArray[6] = cargo6;
        cargoArray[7] = cargo7;
        cargoArray[8] = cargo8;
        cargoArray[9] = cargo9;
        cargoArray[10] = cargo10;


    }

    public JPanel displayCargo(Player player) {
        if (player.getShip().getCargoList().size() == 0) {
            cargo = new JLabel("No cargo");
            cargoPanel.add(cargo);
        } else {
            for (int i = 0; i < player.getShip().getCargoList().size(); i++) {
                if (cargoArray[i] == null || player.getShip().getCargoList().get(i) == null) {
                    continue;
                }

                cargoArray[i].setText(
                        "Name: " + player.getShip().getCargoList().get(i).getName()
                        + " Amount:" + player.getShip().getCargoList().get(i).getAmount()
                        + " Price:" + player.getShip().getCargoList().get(i).getPrice());

                cargoPanel.add(cargoArray[i]);
            }
        }
        return cargoPanel;
    }
    
    public JPanel getCargoPanel() {
        return cargoPanel;
    }
}
