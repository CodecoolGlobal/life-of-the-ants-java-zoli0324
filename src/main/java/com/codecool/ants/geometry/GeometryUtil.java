package com.codecool.ants.geometry;

import com.codecool.ants.Simulator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GeometryUtil {

    public static boolean positionEquals(Position a, Position b) {
        return a.x == b.x && a.y == b.y;
    }

    public static void moveToEdge(Position position, Direction direction) {
        switch (direction) {
            case EAST:
                position.y = Simulator.width - 1;
                break;
            case WEST:
                position.y = 0;
                break;
            case NORTH:
                position.x = 0;
                break;
            case SOUTH:
                position.x = Simulator.width - 1;
                break;
        }
    }


    public static void moveTowardsPoint(Position a, Position b) {
        if (a.x < b.x) {
            a.x += 1;
        } else if (a.x > b.x) {
            a.x -= 1;
        } else if (a.y > b.y) {
            a.y -= 1;
        } else if (a.y < b.y) {
            a.y += 1;
        }
    }

    public static Direction getRandomDirection(Position position) {
        List<Direction> availableDirections = getAvailableDirections(position);

        Random random = new Random();
        Direction randomDirection = availableDirections.get(random.nextInt(availableDirections.size()));

        return randomDirection;
    }

    public static List<Direction> getAvailableDirections(Position position) {
        int x = position.x;
        int y = position.y;

        List<Direction> ret = new LinkedList<>(Arrays.asList(Direction.values()));
        if (y == 0) {
            ret.remove(Direction.WEST);
        }

        if (x == 0) {
            ret.remove(Direction.NORTH);
        }

        if (x == Simulator.width - 1) {
            ret.remove(Direction.SOUTH);
        }

        if (y == Simulator.width - 1) {
            ret.remove(Direction.EAST);
        }

        return ret;
    }

    public static void moveIntoDirection(Position position, Direction direction) {

        switch (direction) {
            case EAST:
                position.y++;
                break;
            case WEST:
                position.y = position.y - 1;
                break;
            case NORTH:
                position.x = position.x - 1;
                break;
            case SOUTH:
                position.x++;
                break;
        }
    }
}
