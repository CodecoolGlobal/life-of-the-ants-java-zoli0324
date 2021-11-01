package com.codecool.ants.ant;

import com.codecool.ants.geometry.Position;

public abstract class Ant {
    protected Position position;

    public Ant(Position position) {
        this.position = position;
    }

    public abstract void act();

    public abstract char getName();

    public Position getPosition() {
        return position;
    }

    public boolean isInPosition(int x, int y) {
        if (this.position.x == x && this.position.y == y) {
            return true;
        } else {
            return false;
        }
    }
}