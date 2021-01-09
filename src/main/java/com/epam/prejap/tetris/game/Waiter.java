package com.epam.prejap.tetris.game;

import com.epam.prejap.tetris.score.ScoreObserver;

import java.util.concurrent.TimeUnit;

/**
 * Responsible for waiting some given time till the next render.
 *
 * @implNote Gets {@link #milliseconds} filed as a constructor argument
 */

public class Waiter implements ScoreObserver {

    private static final int INCREASE_GAME_SPEED_SCORE = 10;
    private static final int DECREASE_WAITING_TIME = 100;

    private int milliseconds;

    public Waiter(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    public void waitForIt() {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException ignore) {
        }
    }

    @Override
    public void scoreChanged(int newScore) {
        if (shouldDecreaseWaitingTime(newScore)) {
            decreaseWaitingTime();
        }
    }

    private boolean shouldDecreaseWaitingTime(int score) {
        return score % INCREASE_GAME_SPEED_SCORE == 0;
    }

    private void decreaseWaitingTime() {
        if (haveEnoughTime()) {
            milliseconds -= DECREASE_WAITING_TIME;
        }
    }

    private boolean haveEnoughTime() {
        return milliseconds - DECREASE_WAITING_TIME > 0;
    }

    public int milliseconds() {
        return milliseconds;
    }
}
