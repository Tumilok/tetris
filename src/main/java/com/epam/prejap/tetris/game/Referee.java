package com.epam.prejap.tetris.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Responsible for holding and increasing the game score
 *
 * @implNote This class evaluates {@link RefereeObserver#levelChanged()} (int)} method
 * when player gets to the next level.
 */

public class Referee {

    private static final int LEVEL_POINTS = 10;

    private final List<RefereeObserver> observers = new ArrayList<>();
    private int currentScore = 0;

    public void increaseScore() {
        currentScore++;
        if (isNextLevel()) {
            levelChanged();
        }
    }

    public int currentScore() {
        return currentScore;
    }

    private boolean isNextLevel() {
        return currentScore % LEVEL_POINTS == 0;
    }

    private void levelChanged() {
        observers.forEach(RefereeObserver::levelChanged);
    }

    public void addObserver(RefereeObserver observer) {
        observers.add(Objects.requireNonNull(observer, "observer must not be null"));
    }

}
