package com.codecool.ants.ant;

import com.codecool.ants.geometry.Position;

import java.util.Random;

public class Queen extends Ant {

    private int moodTimer;

    public Queen(Position position) {
        super(position);
        moodTimer = getNewMoodTimer();
    }

    @Override
    public void act() {
        if (moodTimer >= 0) {
            moodTimer--;
        }

        if (moodTimer == -1) {
            moodTimer = getNewMoodTimer();
        }
    }

    @Override
    public char getName() {
        return 'Q';
    }

    private int getNewMoodTimer() {
        Random random = new Random();
        return random.nextInt(50) + 50;
    }

    public int getMoodTimer() {
        return moodTimer;
    }

}