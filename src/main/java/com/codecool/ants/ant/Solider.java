package com.codecool.ants.ant;

import com.codecool.ants.Simulator;
import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;
import com.codecool.ants.geometry.GeometryUtil;

import java.util.Arrays;
import java.util.List;

class Soldier extends Ant {
    //always move towards a direction
    private int currentDirectionIndex = 0;
    private List<Direction> directionsInOrder = Arrays.asList(Direction.NORTH, Direction.WEST, Direction.SOUTH, Direction.EAST);

    public Soldier(Position position) {
        super(position);

        List<Direction> availableDirections = GeometryUtil.getAvailableDirections(position);
        for (Direction direction : directionsInOrder) {
            if (availableDirections.contains(direction)) {
                currentDirectionIndex = directionsInOrder.indexOf(direction);
                break;
            }
        }

        if (this.position.y == 0) {
            currentDirectionIndex = 2; // go SOUTH
            if (this.position.x == Simulator.width) {
                currentDirectionIndex = 3; // must go EAST
            }
        }
    }


    @Override
    public void act() {

        GeometryUtil.moveIntoDirection(position, directionsInOrder.get(currentDirectionIndex));
        currentDirectionIndex++;
        if (currentDirectionIndex == 4) {
            currentDirectionIndex = 0;
        }
    }

    @Override
    public char getName() {
        return 'S';
    }
}