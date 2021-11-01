package com.codecool.ants.ant;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;
import com.codecool.ants.geometry.GeometryUtil;

public class Worker extends Ant {

    public Worker(Position position) {
        super(position);
    }

    @Override
    public void act() {
        Direction randomDirection = GeometryUtil.getRandomDirection(position);
        GeometryUtil.moveIntoDirection(position, randomDirection);
    }

    @Override
    public char getName() {
        return 'W';
    }
}