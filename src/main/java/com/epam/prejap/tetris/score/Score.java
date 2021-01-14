package com.epam.prejap.tetris.score;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Responsible for holding and increasing the game score
 *
 * @implNote This class evaluates {@link ScoreObserver#levelChanged()} (int)} method
 * when player gets to the next level.
 */

public class Score {

    private static final int LEVEL_POINTS = 10;

    private final List<ScoreObserver> observers = new ArrayList<>();
    private int points = 0;

    public void increaseScore() {
        points++;
        if (isNextLevel()) {
            levelChanged();
        }
    }

    public int points() {
        return points;
    }

    private boolean isNextLevel() {
        return points % LEVEL_POINTS == 0;
    }

    private void levelChanged() {
        observers.forEach(ScoreObserver::levelChanged);
    }

    public void addObserver(ScoreObserver observer) {
        observers.add(Objects.requireNonNull(observer, "observer must not be null"));
    }

}
