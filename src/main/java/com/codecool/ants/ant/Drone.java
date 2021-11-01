package com.codecool.ants.ant;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.GeometryUtil;
import com.codecool.ants.geometry.Position;

public class Drone extends Ant {

    private Queen queen;
    private int matingTimer = 0;

    public Drone(Position position, Queen queen) {
        super(position);
        this.queen = queen;
    }

    @Override
    public void act() {
        if (matingTimer > 0) {
            matingTimer--;
            if (matingTimer == 0) {
                // kicked off
                Direction randomDirection = GeometryUtil.getRandomDirection(position);
                GeometryUtil.moveToEdge(position, randomDirection);
            }
        } else {
            GeometryUtil.moveTowardsPoint(this.position, queen.getPosition());

            if (GeometryUtil.positionEquals(position, queen.getPosition())) {
                if (queen.getMoodTimer() == 0) {
                    matingTimer = 10;
                } else {
                    // kicked off
                    Direction randomDirection = GeometryUtil.getRandomDirection(position);
                    GeometryUtil.moveToEdge(position, randomDirection);
                }
            }

        }
    }

    @Override
    public char getName() {
        return 'D';
    }
}