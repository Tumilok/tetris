package com.epam.prejap.tetris;

import com.epam.prejap.tetris.game.Waiter;

import java.util.Objects;

/**
 * Responsible for holding and increasing the game score
 *
 * @implNote This class evaluates {@link Waiter#decreaseWaitingTime()} method
 * when player gets next 10 points. It gets {@link Waiter} object as a constructor argument
 */

class Score {

    private final Waiter waiter;
    private int points = 0;

    public Score(Waiter waiter) {
        this.waiter = Objects.requireNonNull(waiter, "waiter must not be null");
    }

    public void handleScore() {
        increaseScore();
        handleWaitingTime();
    }

    private void increaseScore() {
        points++;
    }

    private void handleWaitingTime() {
        if (shouldDecreaseWaitingTime()) {
            waiter.decreaseWaitingTime();
        }
    }

    private boolean shouldDecreaseWaitingTime() {
        return points % 10 == 0;
    }

    public int points() {
        return points;
    }

}
