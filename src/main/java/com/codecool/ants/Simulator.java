package com.codecool.ants;

import com.codecool.ants.ant.Colony;

import java.util.Scanner;

public class Simulator {

    public static final String Q = "q";
    public static int width;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // get the width of colony
        System.out.println("Width: ");
        width = in.nextInt();
        System.out.println("Number of workers: ");
        int worker = in.nextInt();
        System.out.println("Number of soldiers: ");
        int soldier = in.nextInt();
        System.out.println("Number of drones: ");
        int drone = in.nextInt();


        Colony colony = new Colony(width);
        colony.generateAnts(worker, soldier, drone);

        String scannedLine = null;
        while (!Q.equals(scannedLine)) {
            scannedLine = in.nextLine();
            if (scannedLine.equals("")) {
                colony.update();
                colony.display();
            }
        }
    }

}