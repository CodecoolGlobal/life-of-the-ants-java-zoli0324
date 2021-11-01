package com.codecool.ants.ant;

import com.codecool.ants.geometry.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Colony {

    private List<Ant> ants;
    private int width;
    private Queen queen;

    public Colony(int width) {
        this.width = width;
        ants = new ArrayList<>();
        this.queen = new Queen(new Position(width/2, width/2));
        ants.add(queen);
    }

    public void generateAnts(int workers, int soldiers, int drones) {
        Random r = new Random();
        for (int i = 0; i < workers; i++) {
            ants.add(new Worker(new Position(r.nextInt(width), r.nextInt(width))));
        }

        for (int i = 0; i < soldiers; i++) {
            ants.add(new Soldier(new Position(r.nextInt(width), r.nextInt(width))));
        }

        for (int i = 0; i < drones; i++) {
            ants.add(new Drone(new Position(r.nextInt(width), r.nextInt(width)), queen));
        }
    }

    //move the ants, call the act method
    public void update() {
        for (Ant ant : ants) {
            ant.act();
        }
    }


    public void display() {
        String matrix = "";
        for (int i = 0; i < width; i++) {
            String line = "";
            for (int j = 0; j < width; j++) {
                line = line + getCharacter(i, j) + "  ";
            }

            matrix = matrix + line + "\n";
        }
        System.out.println(matrix);
    }

    // TODO !!!! ne legyen ennyi ciklus hangyára.
    private char getCharacter(int x, int y) {
        char ret = '.';
        for (Ant ant : ants) {
            if (ant.isInPosition(x, y)) {
                ret = ant.getName();
            }
        }
        return ret;
    }
}