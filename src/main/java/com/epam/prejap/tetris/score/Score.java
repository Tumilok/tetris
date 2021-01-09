package com.epam.prejap.tetris.score;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Responsible for holding and increasing the game score
 *
 * @implNote This class evaluates {@link ScoreObserver#scoreChanged(int)} method
 * when player gets next point.
 */

public class Score {

    private final List<ScoreObserver> observers = new ArrayList<>();
    private int points = 0;

    public void increaseScore() {
        points++;
        scoreChanged();
    }

    public int points() {
        return points;
    }

    private void scoreChanged() {
        observers.forEach(observer -> observer.scoreChanged(points));
    }

    public void addObserver(ScoreObserver observer) {
        observers.add(Objects.requireNonNull(observer, "observer must not be null"));
    }

}
